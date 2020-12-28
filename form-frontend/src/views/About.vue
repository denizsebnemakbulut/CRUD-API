<template>
<div >  
<img alt="My picture" src="../assets/friends.png" >
    <h1 class="about">Lorem, ipsum dolor sit amet consectetur adipisicing elit. Modi placeat voluptatum dolor, laboriosam ducimus excepturi praesentium, exercitationem dolores soluta, incidunt optio earum quaerat! Rem ducimus nihil aperiam eligendi itaque maxime.</h1>
    <div class="homebutton">
        <router-link to = '/home' tag="button">Go Home Page</router-link>
  </div>
  </div>
</template>

<style scoped>
.about{
    margin-top: 40px;

}
img{
    margin-top: 20px;
    height: 30%;
    width: 30%;
}
.poem {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    width: 100%;
    font-size: 40px;
    color: rgb(14, 97, 93);
    font-weight: 600;
    margin-top: 100px;
}
.homebutton {
    display: flex;
    justify-content: center;
    align-items: center;
    color: rgb(14, 97, 93);
    font-weight: 600;
    margin-top: 20px;
}
</style>