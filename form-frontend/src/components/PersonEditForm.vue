<template>
  <div>
      <h3 class="form-header">{{ title }}</h3>

      <div class="form-group">
        <input
          v-model="person.name"
          class="form-control"
          placeholder="Enter person name"
          required="required"
        />
        <div class="help-block form-text with-errors form-control-feedback"></div>
      </div>

      <div class="form-buttons-w">
        <a @click="submit" href="javascript:;" class="btn btn-success mr-3 mt-1">
          <i class="fa fa-plus"></i>
          {{ submitTitle }}
        </a>

        <span v-if="deleteTitle" x>
          <a @click="deletePerson" href="javascript:;" class="btn btn-danger mt-1">
            <i class="fa fa-trash"></i>
            {{ deleteTitle }}
          </a>
        </span>
      </div>
   
  </div>
</template>
<script>
export default {
  props: ["person", "title", "submitTitle", "deleteTitle"],
 
  methods: {
    submit() {
      if (!this.person.name) {
        alert("Lütfen geçerli bir isim giriniz");
        return;
      }
      this.$emit("submit", this.person);
    },
    deletePerson() {
      this.$emit("deletePerson", this.person);
    }
  }
};
</script>
