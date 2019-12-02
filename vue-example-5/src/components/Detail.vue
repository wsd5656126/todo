<template>
  <div class="box">
    <h1>我是详细页面{{id}}</h1>
    <ul>
      <li>
        <div class="p1">
          {{obj.content}}
        </div>
        <div class="p2">
          <img :src="obj.imgUrl">
        </div>

      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'Detail',
  data () {
    return {
      obj:{} ,
      id:this.$route.query.ids
    }
  },
  mounted(){
    var url = "../../static/news.json"
    var self =this;
    this.$ajax.get(url,{
      params:{id:this.id}
    })
      .then(function (response) {
        //console.log(response.data.result.data);
        self.obj = response.data.result.data[0];
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
  .box{
    width: 980px;
  }

  .p1{
    float:left;
    width:700px;
  }
  .p2{
    float:right;
  }
</style>
