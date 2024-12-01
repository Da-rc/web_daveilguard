<template>
  <div class="divLogo">
    <img id="logoDAV" src="../assets/DATV_Logo.webp"/>
  </div>

  <div class="tabla">
   <!-- <h1>{{clase.nombre}} skills</h1> -->
    <div class="menuClases">
      <div class="menu-item"
           :class="{ active: selectedClass === 'Warrior' }"
           @click="selectClase('Warrior')">
        Warrior
      </div>
      <div class="menu-item"
           :class="{ active: selectedClass === 'Rogue' }"
           @click="selectClase('Rogue')">
        Rogue
      </div>
      <div class="menu-item"
           :class="{ active: selectedClass === 'Mage' }"
           @click="selectClase('Mage')">
        Mage
      </div>
    </div>
    <!--tabla de categorias y skills-->
    <table>
      <thead>
        <tr>
          <th>Subclass</th>
          <th>Skill name</th>
          <th>Description</th>
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
      selectedClass: 'Warrior',
    };
  },
  mounted() {
    this.fetchClase("Warrior");
  },
  methods: {
    fetchClase(name) {
      getClaseByName(name)
          .then((response) => {
            this.clase = response.data;
          })
          .catch((error) => {
            console.error("Error fetching class:", error);
          });
    },
    selectClase(name) {
      this.selectedClass = name;
      this.fetchClase(name);
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#logoDAV {
  max-width: 70%;
}

.menuClases{
  display: flex;
  align-items: center;
  justify-content: space-around;
  width: 80%;
  margin: 0 auto;
  padding: 10px 0;
  background: linear-gradient(to right, #ffffff, #f3f4f6);
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.menu-item{
  flex: 1;
  text-align: center;
  color: #505050;
  font-size: 16px;
  font-weight: 500;
  cursor: pointer;
  transition: color 0.3s ease, transform 0.2s ease;
}

.menu-item.active {
  color: #6c4675;
  font-weight: bold;
}

.menu-item:hover{
  color: #6c4675;
  transform: scale(1.1);
}

table {
  width: 90%;
  max-width: 1000px;
  border-collapse: collapse;
  margin: 30px auto;
  background-color: #ffffff;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
  overflow: hidden;
}

th, td {
  border: 1px solid #e0e0e0;
  padding: 12px;
  text-align: left;
  font-size: 14px;
}

th {
  background-color: #f4f4f4;
  color: #555;
  font-weight: 600;
}

tr:nth-child(even) {
  background-color: #f9f9f9;
}

tr:hover {
  background-color: #f1f1f1;
}

/*Responsive*/
@media (max-width: 768px){
  .menuClases {
    flex-direction: column;
    align-items: center;
    padding: 10px 5%;
  }

  .menu-item {
    flex: none;
    width: 100%;
    font-size: 15px;
    margin: 5px 0;
  }

  table {
    width: 95%;
  }

  th, td {
    font-size: 12px;
    padding: 8px;
  }
}

@media (max-width: 480px){
  .menuClases {
    padding: 8px 2%;
  }

  .menu-item {
    font-size: 14px;
  }

  table {
    font-size: 12px;
  }
}

</style>
