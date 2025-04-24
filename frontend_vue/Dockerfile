# Etapa 1: Build da aplicação
FROM node:18 AS build
WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build

# Etapa 2: Servir com Nginx
FROM nginx:alpine
COPY --from=build /app/dist /usr/share/nginx/html

# (Opcional) Sobrescrever config Nginx
# COPY nginx.conf /etc/nginx/nginx.conf

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
