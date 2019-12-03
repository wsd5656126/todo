<template>
  <div class="items">

    <div class="items-left">
      <a class="items-line" v-for="item in items" @click="units(item.itemId)">
      <span class="items-line-left">
        <i class="iconfont" v-if="item.locked == 1">&#xe7c4;</i>
      </span>
        <span class="items-line-center">{{item.itemName}}</span>
        <span class="items-line-right">{{item.unitNum}}</span>
      </a>
      <div class="items-add">
        <a class="items-add-a" @click="addItem">新增</a>
      </div>
    </div>

    <units class="items-right"></units>
  </div>
</template>
<script>
import {get} from '../util/http'
import Units from "./Units";

export default {
  name: 'Items',
  components: {Units},
  data() {
    return {
      items: []
    }
  },
  created() {
    get('/item/list').then(res => {
      // console.log(res)
      this.items = res
      console.log(this.items)
    }).catch(err => {
      console.log('err')
      console.log(err);
    })
  },
  methods: {
    units: function (itemId) {
      console.log('units()' + itemId)
      var id = itemId;
      var path = `/units/${id}`;
      this.$router.push({
        path: path
      })
    },
    initAll: function () {
      var itemId;
      get('/item/list').then(res => {
        console.log('initAll')
        this.items = res
        if (this.items.length > 0) {
          itemId = this.items[0].itemId;
        }
        console.log(this.items)
      }).catch(err => {
        console.log('err')
        console.log(err);
      })
      return itemId;
    },
    addItem: function () {
      console.log('addItem()')
      get('/item/add')
        .then(res => {
          get('item/list')
            .then(res2 => {
              this.items = res2
            })
        })
    }
  },
}
</script>

<style scoped>
  .items-line {
    display: flex;
  }

  .items-line-left {
    margin-left: 10%;
    width: 10%;
  }

  .items-line-center {
    width: 40%;
  }

  .items-line-right {
    width: 10%;
  }

  .items-add-a {
    text-align: center;
  }

  a:hover {
    color: #0077aa;
  }

  .items {
    display: flex;
  }
  .items-left {
    width: 30%;
  }
  .items-right {
    width: 70%;
  }
</style>
