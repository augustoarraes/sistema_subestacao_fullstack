const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: 3001 // só é usado em ambiente de desenvolvimento local com o 'npm run serve' (modo dev)
  }
})

// .. Quando você faz 'npm run build' para produção e serve via Nginx, esse arquivo é ignorado.'