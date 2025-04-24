<template>
    <div class="container">
      <h2>Atualizar Subestação</h2>

      <div class="card">
        <form @submit.prevent>
            <input type="hidden" :value="subestacao.idSubestacao" />
          <div class="form-row">
            <label>Código</label>
            <input :value="subestacao.codigo" readonly />
          </div>
          <div class="form-row">
            <label>Nome</label>
            <input v-model="subestacao.nome" required />
          </div>
          <div class="form-row">
            <label>Latitude</label>
            <input v-model.number="subestacao.latitude" type="number" required />
          </div>
          <div class="form-row">
            <label>Longitude</label>
            <input v-model.number="subestacao.longitude" type="number" required />
          </div>
        </form>
      </div>

      <h3>Redes MT</h3>
      <div class="card">
        <table v-if="Array.isArray(subestacao.redeMT) && subestacao.redeMT.length" border="1" cellpadding="5" cellspacing="0" style="width: 100%;">
          <thead>
            <tr>
              <th>Código</th>
              <th>Nome</th>
              <th>Tensão Nominal</th>
              <th>Ações</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(rede, index) in subestacao.redeMT" :key="index">
              <td>
                <input :value="rede.codigo" readonly />
              </td>
              <td>
                <input v-model="rede.nome" />
              </td>
              <td>
                <input v-model.number="rede.tensaoNominal" type="number" />
              </td>
              <td>
                <button @click="excluirRedeMT(rede, index)" title="Excluir">🗑️</button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>

      <div class="acoes">
        <button @click="efetivarAlteracoes">Efetivar Alterações</button>
        <button @click="cancelar">Cancelar</button>
      </div>
    </div>
  </template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'

const router = useRouter()
const route = useRoute()

const subestacao = ref({
  idSubestacao: null,
  codigo: '',
  nome: '',
  latitude: null,
  longitude: null,
  redeMT: []
})

const carregarDados = async () => {
  try {
    const id = route.params.idSubestacao
    const respSub = await fetch(`http://localhost:8080/subestacao/${id}`)
    const dados = await respSub.json()
    subestacao.value = { ...dados }

    const respRede = await fetch(`http://localhost:8080/subestacao/${id}/redesMT`)
    const redes = await respRede.json()
    subestacao.value.redeMT = redes
  } catch (err) {
    console.error('Erro ao carregar dados:', err)
  }
}

const efetivarAlteracoes = async () => {
  try {
    const response = await fetch('http://localhost:8080/subestacao', {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(subestacao.value)
    })

    if (response.ok) {
      alert('Alterações salvas com sucesso!')
      router.push('/lista')
    } else {
      alert('Erro ao salvar alterações.')
    }
  } catch (err) {
    console.error(err)
    alert('Erro de conexão.')
  }
}

const excluirRedeMT = async (redeMT, index) => {
  const confirmar = window.confirm(`Deseja realmente excluir a RedeMT: ${redeMT.nome}?`)
  if (!confirmar) return

  try {
    const resp = await fetch(`http://localhost:8080/subestacao/redesMT/${redeMT.idRedeMT}`, {
      method: 'DELETE'
    })

    if (resp.ok) {
      // Remove da lista em memória
      subestacao.value.redeMT.splice(index, 1)
      alert('RedeMT excluída com sucesso.')
    } else {
      alert('Erro ao excluir RedeMT.')
    }
  } catch (err) {
    console.error(err)
    alert('Erro na comunicação com o servidor.')
  }
}

const cancelar = () => {
  router.push('/lista')
}

onMounted(carregarDados)
</script>

  <style scoped>
  .container {
    padding: 20px;
    font-family: Arial, sans-serif;
  }

  .card {
    background-color: #f7f7f7;
    border: 1px solid #ccc;
    padding: 20px;
    margin-bottom: 20px;
    border-radius: 8px;
  }

  .form-row {
    display: flex;
    align-items: center;
    margin-bottom: 10px;
  }

  label {
    width: 150px;
    font-weight: bold;
    margin-right: 10px;
  }

  input {
    flex: 1;
    padding: 6px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }

  table input {
    width: 100%;
    box-sizing: border-box;
  }

  button {
    margin-top: 15px;
    padding: 8px 16px;
    margin-right: 10px;
    background-color: #42b983;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }

  button:last-child {
    background-color: #999;
  }

  .acoes {
    margin-top: 30px;
  }
  </style>
