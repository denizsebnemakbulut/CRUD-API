
<template>
  <div id="app">
    <router-view></router-view>
    </div>
</template>

<script>
export default {
  name :'app',
}
</script>

<style scoped>

#app {
  font-family: 'Roboto', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #480caa;
  margin-right:30px;
}

body {
  margin: 0px;
  padding: 0px;
  box-sizing: border-box;
}
</style>
