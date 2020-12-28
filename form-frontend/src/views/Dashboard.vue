<template>
    <div class="dashboard">
        <MenuBar/>
        <div class ="content">
            <router-view/>
        </div>
    </div>
</template>
<script>
import MenuBar from '../components/MenuBar'
export default {
   name: 'home',
   
   components: {
       MenuBar
    }
}
</script>

<style scoped>
.dashboard {
    display:grid;
    grid-template-columns: 1fr 5fr;
    background-color: rgb(152, 95, 190);
    height: 100vh;
    width: 95vw;
    border-radius: 20px;
}
.content {
    background-color: white;
    border-radius: 20px;
    margin: 6px 6px 6px 0px;
}
</style>