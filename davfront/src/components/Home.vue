<template>

    <div class="menu">
      <div class="menu-item">
        Clase 1
      </div>
      <div class="menu-item">
        Clase 2
      </div>
      <div class="menu-item">
        Clase 3
      </div>
    </div>
  <div class="tabla">
   <h1>Habilidades de la Clase: {{clase.nombre}}</h1>

    <!--tabla de categorias y skills-->
    <table>
      <thead>
        <tr>
          <th>Categoría</th>
          <th>Nombre</th>
          <th>Descripcion</th>
        </tr>
      </thead>
      <tbody>
        <template v-for="categoria in clase.categorias" :key="categoria.id">
          <tr v-for="habilidad in categoria.habilidades" :key="habilidad.id">
            <td>{{ categoria.nombre }}</td>
            <td>{{ habilidad.nombre }}</td>
            <td>{{ habilidad.descripcion }}</td>
          </tr>
          <tr v-if="categoria.habilidades.length === 0">
            <td>{{categoria.nombre}}</td>
            <td colspan="2">No hay registros</td>
          </tr>
        </template>
      </tbody>
    </table>
  </div>
</template>

<script>

import {getClaseByName} from "@/axios";

export default {
  name: 'HomePage',
  data() {
    return {
      clase: {
        id: '',
        nombre: '',
        categorias: [],
      },
    };
  },
  mounted() {
    getClaseByName('Warrior')
        .then((response) => {
          this.clase = response.data;
        })
        .catch((error) => {
          console.log(error);
        })
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.menu{
  display: flex;
  align-items: center;
  justify-content: space-around;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 1000;
  padding: 10px 0;
  background: #fff;

}

.menu-item{
  flex: 1;
  text-align: center;
  color: #707070;
  border: solid 2px red;
}

.menu-item:hover{
  color: red;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin: 20px 0;
}

th, td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

th {
  background-color: #f4f4f4;
}

/*Responsive*/
@media (max-width: 768px){
  /*.menu{
    flex-direction: column;
    align-items: flex-start;
    width: auto;
    padding: 10px;
  }

  .menu-item{
    flex: none;
    margin: 5px 0;
    text-align: left;
    width: 100%;
  }*/
}

@media (max-width: 480px){
  /*.menu{
    font-size: 14px;
    align-items: flex-start;
    width: auto;
    padding: 5px;
  }

  .menu-item{
    margin: 3px 0;
  }*/
}

</style>
