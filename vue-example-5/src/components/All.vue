<template>
  <div class='box'>
    <ul>
      <li v-for='item in arr'>
        <div class='p1'>
          <router-link :to="{path:'/detail',query:{ids:item.id}}">{{item.content}}</router-link>
        </div>
        <div class="p2">
          <img :src="item.imgUrl">
        </div>
      </li>
    </ul>

  </div>
</template>

<script>
export default {
  name: 'All',
  data() {
    return {
      arr: []
    }
  },
  mounted() {
    var url = 'http://localhost:9000/new/list'
    var self = this;
    this.$ajax.get(url)
      .then(function (response) {
        console.log(response);
        self.arr = response.data;
      })
      .catch(function (error) {
        console.log(error);
      })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }

  .box {
    width: 980px;
  }

  .p1 {
    float: left;
    width: 780px;
  }

  img {
    float: right;
  }
</style>
