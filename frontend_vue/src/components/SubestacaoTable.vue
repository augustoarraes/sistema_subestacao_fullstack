<template>
    <div class="container">
        <h2>Lista de Subestações</h2>
        <table border="1" cellpadding="10" cellspacing="0">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="sub in subestacoes" :key="sub.idSubestacao">
                    <td>{{ sub.codigo }}</td>
                    <td>{{ sub.nome }}</td>
                    <td>
                        <button @click="exibirMapa(sub)" title="Exibir no mapa">🌍</button>
                        <button @click="alterar(sub)" title="Alterar">✏️</button>
                        <button @click="excluir(sub.idSubestacao)" title="Excluir">🗑️</button>
                    </td>
                </tr>
            </tbody>
        </table>

        <button @click="incluir" class="btn-incluir" style="margin-top: 20px;">Incluir</button>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
// const baseUrl = process.env.VUE_APP_API_URL
const router = useRouter()

const subestacoes = ref([])

const carregarSubestacoes = async () => {
  try {
    const resp = await fetch('http://localhost:8080/subestacao')
    subestacoes.value = await resp.json()
  } catch (err) {
    console.error('Erro ao carregar subestações:', err)
  }
}

const excluir = async (id) => {
  const confirmado = window.confirm('Deseja realmente excluir esta subestação?')
  if (!confirmado) return

  try {
    const resp = await fetch(`http://localhost:8080/subestacao/${id}`, {
      method: 'DELETE'
    })

    if (resp.ok) {
      // alert('Subestação excluída com sucesso.')
      carregarSubestacoes() // Recarrega a lista
    } else {
      alert('Erro ao excluir subestação.')
    }
  } catch (err) {
    console.error('Erro na exclusão:', err)
    alert('Erro na exclusão. Verifique o console.')
  }
}

const alterar = (sub) => {
  console.log('Alterar', sub)
  router.push(`/atualizar/${sub.idSubestacao}`)
}

const exibirMapa = (sub) => {
  router.push({
    name: 'SubestacaoMapa',
    params: {
      idSubestacao: sub.idSubestacao,
      codigo: sub.codigo,
      nome: sub.nome,
      latitude: sub.latitude,
      longitude: sub.longitude
    }
  })
}

const incluir = () => {
  console.log('Incluir nova subestação')
  router.push('/cadastro')
}

onMounted(carregarSubestacoes)
</script>

<style scoped>
.container {
    padding: 20px;
    font-family: Arial, sans-serif;
}

table {
    width: 100%;
    border-collapse: collapse;
}

th {
    background-color: #f0f0f0;
}

button {
    margin: 0 5px;
}

.btn-incluir {
  margin-bottom: 20px;
  padding: 10px 20px;
  background-color: #42b983;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

</style>
