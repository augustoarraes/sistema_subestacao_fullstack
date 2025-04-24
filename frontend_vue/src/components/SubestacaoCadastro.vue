<template>
    <div class="container">
      <h2>Cadastro de Subestação</h2>

      <!-- Formulário Subestação -->
      <div class="card">
        <form @submit.prevent>
          <div class="form-row">
            <label>Nome</label>
            <input v-model="subestacao.nome" required />
          </div>
          <div class="form-row">
            <label>Código</label>
            <input v-model="subestacao.codigo" required />
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

      <h3>Cadastro de Rede MT</h3>

      <!-- Formulário + Tabela RedesMT no mesmo card -->
      <div class="card">
        <form @submit.prevent="adicionarRedeMT">
          <div class="form-row">
            <label>Código</label>
            <input v-model="novaRede.codigo" required />
          </div>
          <div class="form-row">
            <label>Nome</label>
            <input v-model="novaRede.nome" required />
          </div>
          <div class="form-row">
            <label>Tensão Nominal</label>
            <input v-model.number="novaRede.tensaoNominal" type="number" required />
          </div>
          <button type="submit">Adicionar RedeMT</button>
        </form>

        <!-- Tabela dentro do mesmo card -->
        <table v-if="subestacao.redeMT.length" border="1" cellpadding="5" cellspacing="0" style="margin-top: 20px; width: 100%;">
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
              <td>{{ rede.codigo }}</td>
              <td>{{ rede.nome }}</td>
              <td>{{ rede.tensaoNominal }}</td>
              <td>
                <button @click="removerRedeMT(index)" title="Excluir">🗑️</button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>

      <!-- Botões de ação -->
      <div class="acoes">
        <button @click="incluir">Incluir</button>
        <button @click="cancelar">Cancelar</button>
      </div>
    </div>
  </template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()

const subestacao = ref({
  nome: '',
  codigo: '',
  latitude: null,
  longitude: null,
  redeMT: []
})

const novaRede = ref({
  codigo: '',
  nome: '',
  tensaoNominal: null
})

const adicionarRedeMT = () => {
  subestacao.value.redeMT.push({ ...novaRede.value })
  novaRede.value = { codigo: '', nome: '', tensaoNominal: null }
}

const incluir = async () => {
  try {
    const response = await fetch('http://localhost:8080/subestacao', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(subestacao.value)
    })

    if (response.ok) {
      alert('Subestação incluída com sucesso!')
      router.push('/lista')
    } else {
      alert('Erro ao incluir subestação.')
    }
  } catch (err) {
    console.error('Erro:', err)
    alert('Erro de conexão.')
  }
}

const cancelar = () => {
  router.push('/lista')
}

const removerRedeMT = (index) => {
  subestacao.value.redeMT.splice(index, 1)
}
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

  table button {
  padding: 5px 10px;
  background-color: #e74c3c;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  }

  table button:hover {
    background-color: #c0392b;
  }

  .acoes {
    margin-top: 30px;
  }
  </style>
