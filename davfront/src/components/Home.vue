<template>

    <div class="menu">
      <div class="menu-item">
        Clase 1
      </div>
      <div class="menu-item">
        Clase 2
      </div>
    </div>
  <div class="hello">
   Hello
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
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

/*Responsive*/
@media (max-width: 768px){
  .menu{
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
  }
}

@media (max-width: 480px){
  .menu{
    font-size: 14px;
    align-items: flex-start;
    width: auto;
    padding: 5px;
  }

  .menu-item{
    margin: 3px 0;
  }
}

</style>
