<template>
  <div>
    <div class="line flex">
      <div class="units-left">
        <input v-model="item.itemName" v-on:keyup.enter="modifyItem">
      </div>
      <div class="units-right">
        <span>locked</span>
        <i v-on:click="deleteItem">&#xe7c4;</i>
      </div>
    </div>

    <div class="line flex">
      <input class="units-left" v-model="newUnit.unitName" v-on:keyup.enter="addUnit">
    </div>
    <div class="line flex" v-for="unit in units">
      <div class="units-left">
        <input type="checkbox">
        <a>{{unit.unitName}}</a>
      </div>
      <div class="units-right">
        <span>delete</span>
      </div>
    </div>
  </div>
</template>
<script>
import {get, post} from '../util/http'

export default {
  name: 'Units',
  data() {
    return {
      item: {},
      units: [],
      newUnit: {}
    }
  },
  created: function () {
    var itemId = this.$route.params.id
    get('item/detail', {
      itemId: itemId
    }).then(res => {
      this.item = res;
    }).catch(err => {
      console.log(err)
    });
  },
  watch: {
    '$route'(to, from) {
      var itemId = this.$route.params.id
      console.log('itemId:' + itemId)
      get('item/detail', {
        itemId: itemId
      }).then(res => {
        this.item = res;
      }).catch(err => {
        console.log(err)
      });
      get('unit/list', {
        itemId: itemId
      }).then(res => {
        this.units = res;
      }).catch(err => {
        console.log(err)
      })
    }
  },
  methods: {
    modifyItem: function () {
      var self = this
      post('/item/modify', {
        itemId: this.item.itemId,
        itemName: this.item.itemName
      }).then(res => {
        console.log('modifyItem')
        this.$parent.initAll()
        console.log(res)
      }).catch(err => {
        console.log('err')
        console.log(err)
      })
    },
    addUnit: function () {
      get('/unit/modify', {
        itemId: this.item.itemId,
        unitName: this.newUnit.unitName,
        status: 1
      }).then(res => {
        get('/unit/list', {
          itemId: this.item.itemId,
        }).then(res => {
          this.units = res
        })
      })
    },
    deleteItem: function () {
      post('/item/modify', {
        itemId: this.item.itemId,
        state: 0
      }).then(res => {
        this.$router.push({path: '/items'})
      }).catch(err => {
        console.log('err')
        console.log(err)
      });
    }
  }
}
</script>

<style scoped>
  .flex {
    display: flex;
    width: 70%;
  }

  .units-left {
    margin-right: auto;
  }

  .units-right {
    margin-left: auto;
  }
</style>
