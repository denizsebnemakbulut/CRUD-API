<template>
  <div class="home">
    <div>
      <PersonList/>
    </div>
  </div>
</template>
<script>

import PersonList from "./PersonList";

export default {
  name: "home",
  components: { PersonList },
  mounted() {}
};
</script>
