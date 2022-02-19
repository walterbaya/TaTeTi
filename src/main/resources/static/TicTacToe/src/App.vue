<template>
  <main>
    <table>
      <tr>
        <td>
          <Cell v-on:click="setIcon({ 'row': 0, 'col': 0 })"></Cell>
        </td>
        <td>
          <Cell v-on:click="setIcon({ 'row': 0, 'col': 1 })"></Cell>
        </td>
        <td>
          <Cell v-on:click="setIcon({ 'row': 0, 'col': 2 })"></Cell>
        </td>
      </tr>
      <tr>
        <td>
          <Cell v-on:click="setIcon({ 'row': 1, 'col': 0 })"></Cell>
        </td>
        <td>
          <Cell v-on:click="setIcon({ 'row': 1, 'col': 1 })"></Cell>
        </td>
        <td>
          <Cell v-on:click="setIcon({ 'row': 1, 'col': 2 })"></Cell>
        </td>
      </tr>
      <tr>
        <td>
          <Cell v-on:click="setIcon({ 'row': 2, 'col': 0 })"></Cell>
        </td>
        <td>
          <Cell v-on:click="setIcon({ 'row': 2, 'col': 1 })"></Cell>
        </td>
        <td>
          <Cell v-on:click="setIcon({ 'row': 2, 'col': 2 })"></Cell>
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

export default {
  name: 'App',
  components: {
    Cell
  },
  methods: {
    setIcon(position) {
      const instance = axios.create({
        headers: {
          'Access-Control-Allow-Origin': '*',
        },
        baseURL: 'http://localhost:8080'
      });

      instance.post('/humanPlay', position)
        .then(function (response) {
          let positionData = response.data;
          
          console.log(response.data);
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  },
  data() {
    return {
      circle: "circle",
      cross: "cross"
    }
  },
}

</script>