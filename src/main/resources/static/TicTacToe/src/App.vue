<template>
  <main>
    <table>
      <tr>
        <td>
          <Cell id="cel00" v-on:click="setIcon({ 'row': 0, 'col': 0 })"></Cell>
        </td>
        <td>
          <Cell id="cel01" v-on:click="setIcon({ 'row': 0, 'col': 1 })"></Cell>
        </td>
        <td>
          <Cell id="cel02" v-on:click="setIcon({ 'row': 0, 'col': 2 })"></Cell>
        </td>
      </tr>
      <tr>
        <td>
          <Cell id="cel10" v-on:click="setIcon({ 'row': 1, 'col': 0 })"
              v-bind:image="this.cel00"
          ></Cell>
        </td>
        <td>
          <Cell id="cel11" v-on:click="setIcon({ 'row': 1, 'col': 1 })"></Cell>
        </td>
        <td>
          <Cell id="cel12" v-on:click="setIcon({ 'row': 1, 'col': 2 })"></Cell>
        </td>
      </tr>
      <tr>
        <td>
          <Cell id="cel20" v-on:click="setIcon({ 'row': 2, 'col': 0 })"></Cell>
        </td>
        <td>
          <Cell id="cel21" v-on:click="setIcon({ 'row': 2, 'col': 1 })"></Cell>
        </td>
        <td>
          <Cell id="cel22" v-on:click="setIcon({ 'row': 2, 'col': 2 })"></Cell>
        </td>
      </tr>
    </table>
  </main>
</template>

<style>
@import "./assets/css/index.css";
</style>

<script>

import axios from 'axios';
import Cell from './components/Cell.vue';
import circle from "./assets/img/circle.png";
import cross from "./assets/img/cross.png";

const icon = {circle: circle, cross: cross}      

function makePost(position) {
      return axios.post('/humanPlay', position)
                    .then(response => response)
                    .catch(error => console.log(error));
}


export default {
  name: 'App',
  components: {
    Cell
  },
  data() {
    return {cell00: "", cell01: "", cell02: "", cell10: "", cell11: "", cell12: "",
            cell20: "", cell21: "", cell22: ""
    }
  },
  methods: {
    setIcon(position) {
      
      axios.defaults.baseURL = 'http://localhost:8080';
      axios.defaults.headers = {'Access-Control-Allow-Origin': '*'};

      let promise1 = makePost(position);
      console.log(promise1)
      let promise2 = promise1.then(response => response.data).then(value => value)
      console.log(promise2);

        //this.$data['cell' + positionPlayer.row + "" + positionPlayer.col] = icon.circle;
        //this.$data['cell' + positionBot.row + "" + positionBot.col] = icon.cross;
    }
  },
}

</script>