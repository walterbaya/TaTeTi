<template>
  <main>
    <table>
      <tr>
        <td>
          <Cell v-bind:cell_number="1"
           v-bind:draw="circle"></Cell>
        </td>
        <td>
          <Cell v-bind:cell_number="2"></Cell>
        </td>
        <td>
          <Cell v-bind:cell_number="3"></Cell>
        </td>
      </tr>
      <tr>
        <td>
          <Cell v-bind:cell_number="4"></Cell>
        </td>
        <td>
          <Cell v-bind:cell_number="5"></Cell>
        </td>
        <td>
          <Cell v-bind:cell_number="6"></Cell>
        </td>
      </tr>
      <tr>
        <td>
          <Cell v-bind:cell_number="7"></Cell>
        </td>
        <td>
          <Cell v-bind:cell_number="8"></Cell>
        </td>
        <td>
          <Cell v-bind:cell_number="8"></Cell>
        </td>
      </tr>
    </table>
  </main>
</template>

<style>
@import "./assets/css/index.css";
</style>

<script>
import Cell from './components/Cell.vue';
import Cell1 from './components/Cell.vue';

export default {
  name: 'App',
  components: {
    Cell,
    Cell1
  },
  data() {
    return {

    }
  },
}

</script>