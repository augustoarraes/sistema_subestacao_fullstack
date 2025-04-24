<template>
  <div class="container">
    <h2>Detalhes da Subestação</h2>

    <div class="card">
      <form>
        <div class="form-row">
          <label>ID</label>
          <input :value="subestacao.idSubestacao" readonly />
        </div>
        <div class="form-row">
          <label>Código</label>
          <input :value="subestacao.codigo" readonly />
        </div>
        <div class="form-row">
          <label>Nome</label>
          <input :value="subestacao.nome" readonly />
        </div>
        <div class="form-row">
          <label>Latitude</label>
          <input :value="subestacao.latitude" readonly />
        </div>
        <div class="form-row">
          <label>Longitude</label>
          <input :value="subestacao.longitude" readonly />
        </div>
      </form>

      <button @click="abrirModal">Ver RedesMT</button>
    </div>

    <iframe
      :src="`https://maps.google.com/maps?q=${subestacao.latitude},${subestacao.longitude}&z=15&output=embed`"
      width="100%"
      height="400"
      frameborder="0"
      style="border:0"
      allowfullscreen
    ></iframe>

    <button @click="$router.push('/lista')" class="btn-voltar">Voltar</button>

    <!-- Modal -->
    <div v-if="mostrarModal" class="modal-overlay" @click.self="fecharModal">
      <div class="modal-content">
        <h3>Redes MT da Subestação</h3>
        <table border="1" cellpadding="5" cellspacing="0" style="width: 100%;">
          <thead>
            <tr>
              <th>Código</th>
              <th>Nome</th>
              <th>Tensão Nominal</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="rede in redesMT" :key="rede.idRedeMT">
              <td>{{ rede.codigo }}</td>
              <td>{{ rede.nome }}</td>
              <td>{{ rede.tensaoNominal }}</td>
            </tr>
          </tbody>
        </table>
        <button @click="fecharModal" style="margin-top: 10px;">Fechar</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()
const subestacao = ref({
  idSubestacao: route.params.idSubestacao,
  codigo: route.params.codigo,
  nome: route.params.nome,
  latitude: route.params.latitude,
  longitude: route.params.longitude
})

const mostrarModal = ref(false)
const redesMT = ref([])

const abrirModal = async () => {
  try {
    const response = await fetch(`http://localhost:8080/subestacao/${subestacao.value.idSubestacao}/redesMT`)
    redesMT.value = await response.json()
    mostrarModal.value = true
  } catch (err) {
    console.error('Erro ao buscar redes MT:', err)
    alert('Erro ao carregar redes MT.')
  }
}

const fecharModal = () => {
  mostrarModal.value = false
}
</script>

<style scoped>
.container {
  padding: 20px;
  font-family: Arial, sans-serif;
}

.card {
  background-color: #f7f7f7;
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 20px;
  margin-bottom: 30px;
}

.form-row {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

label {
  width: 100px;
  font-weight: bold;
  margin-right: 10px;
}

input[readonly] {
  flex: 1;
  padding: 8px;
  background-color: #eee;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.btn-voltar {
  margin-top: 20px;
  padding: 10px 20px;
  background-color: #42b983;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

/* Modal */
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0,0,0,0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 999;
}

.modal-content {
  background-color: white;
  padding: 20px;
  width: 600px;
  border-radius: 8px;
  max-height: 80vh;
  overflow-y: auto;
}
</style>
