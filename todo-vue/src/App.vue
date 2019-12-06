<template>
  <div id="app">
    <items class="app-left"></items>
  </div>
</template>

<script>
import Items from "./components/Items";

export default {
  name: 'App',
  components: {Items},
}
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 20px;
  }

  body {
    margin: 0 auto;
    width: 70%;
    background: #a8c5ff;
  }

</style>
