<template>
  <div class="login-wrapper">
    <!-- Quadro do título -->
    <div class="titulo-card">
      Sistema Teste Desenvolvedor Java - Versão 1.5
    </div>

    <!-- Quadro com a imagem como fundo -->
    <div class="imagem-card">
      <!-- Quadro interno do formulário -->
      <div class="formulario-box">
        <form @submit.prevent="entrar">
          <label for="usuario">Usuário</label>
          <input type="text" id="usuario" v-model="usuario" />

          <label for="senha">Senha</label>
          <input type="password" id="senha" v-model="senha" />

          <button type="submit">Entrar</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const usuario = ref('')
const senha = ref('')
const router = useRouter()

const entrar = () => {
  router.push('/lista')
}
</script>

<style scoped>
/* Estrutura principal */
.login-wrapper {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #eaeaea;
  height: 100vh;
  padding: 30px;
  box-sizing: border-box;
}

/* Título destacado */
.titulo-card {
  background-color: white;
  padding: 20px 40px;
  font-size: 20px;
  font-weight: bold;
  border-radius: 10px;
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.15);
  margin-bottom: 30px;
}

/* Quadro da imagem */
.imagem-card {
  position: relative;
  width: 70%; /* reduz imagem para 70% */
  aspect-ratio: 16 / 9;
  background-image: url('grid.jpg');
  background-size: contain;
  background-repeat: no-repeat;
  background-position: center;
  border: 1px solid #ccc;
  border-radius: 12px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

/* Formulário dentro da imagem */
.formulario-box {
  position: absolute;
  bottom: 20px;
  right: 20px;
  background-color: white;
  padding: 20px;
  width: 280px;
  border-radius: 8px;
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.2);
}

/* Estilo dos campos */
form {
  display: flex;
  flex-direction: column;
}

label {
  margin: 10px 0 5px;
  font-weight: bold;
}

input {
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  margin-top: 15px;
  padding: 10px;
  background-color: #42b983;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
</style>
