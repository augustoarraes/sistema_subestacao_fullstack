import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import SubestacaoLogin from '../components/SubestacaoLogin.vue'
import SubestacaoTable from '../components/SubestacaoTable.vue'
import SubestacaoMapa from '../components/SubestacaoMapa.vue'
import SubestacaoCadastro from '../components/SubestacaoCadastro.vue'
import SubestacaoAtualizar from '../components/SubestacaoAtualizar.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'Login',
    component: SubestacaoLogin
  },
  {
    path: '/lista',
    name: 'Lista',
    component: SubestacaoTable
  },
  {
    path: '/mapa/:idSubestacao/:codigo/:nome/:latitude/:longitude',
    name: 'SubestacaoMapa',
    component: SubestacaoMapa,
    props: true
  },
  {
    path: '/cadastro',
    name: 'SubestacaoCadastro',
    component: SubestacaoCadastro
  },
  {
    path: '/atualizar/:idSubestacao',
    name: 'Atualizar',
    component: SubestacaoAtualizar,
    props: true
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
