<template>
  <div>
    {{api}}
  </div>
</template>

<script>
  // import {apiAddress} from "../util/api";
  import {get} from "../util/http";

  export default {
    name: "ApiAddress",
    data() {
      return {api: {}}
    },
    created() {
      this.onload();
    },
    methods: {
      onload() {
        var self = this;
        get("/new/list", {
          type: 0,
          sort: 1
        }).then(res => {
          console.log(res);
          self.api = res;
        })
      }
    }
  }
</script>

<style scoped>

</style>
