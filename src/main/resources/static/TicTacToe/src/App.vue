<template>
  <main>
    <table>
      <tr>
        <td>
          <Cell
            v-on:click="setIcon({ row: 0, col: 0 })"
            v-bind:image="this.board.cell00"
          ></Cell>
        </td>
        <td>
          <Cell
            v-on:click="setIcon({ row: 0, col: 1 })"
            v-bind:image="this.board.cell01"
          ></Cell>
        </td>
        <td>
          <Cell
            v-on:click="setIcon({ row: 0, col: 2 })"
            v-bind:image="this.board.cell02"
          ></Cell>
        </td>
      </tr>
      <tr>
        <td>
          <Cell
            v-on:click="setIcon({ row: 1, col: 0 })"
            v-bind:image="this.board.cell10"
          ></Cell>
        </td>
        <td>
          <Cell
            v-on:click="setIcon({ row: 1, col: 1 })"
            v-bind:image="this.board.cell11"
          ></Cell>
        </td>
        <td>
          <Cell
            v-on:click="setIcon({ row: 1, col: 2 })"
            v-bind:image="this.board.cell12"
          ></Cell>
        </td>
      </tr>
      <tr>
        <td>
          <Cell
            v-on:click="setIcon({ row: 2, col: 0 })"
            v-bind:image="this.board.cell20"
          ></Cell>
        </td>
        <td>
          <Cell
            v-on:click="setIcon({ row: 2, col: 1 })"
            v-bind:image="this.board.cell21"
          ></Cell>
        </td>
        <td>
          <Cell
            v-on:click="setIcon({ row: 2, col: 2 })"
            v-bind:image="this.board.cell22"
          ></Cell>
        </td>
      </tr>
    </table>
  </main>
  {{ this.board }}
</template>

<style>
@import "./assets/css/index.css";
</style>

<script>
import axios from "axios";
import Cell from "./components/Cell.vue";
import circle from "./assets/img/circle.png";
import cross from "./assets/img/cross.png";

const icon = { circle: circle, cross: cross };

axios.defaults.baseURL = "http://localhost:8080";
axios.defaults.headers = { "Access-Control-Allow-Origin": "*" };

export default {
  name: "App",
  components: {
    Cell,
  },
  data() {
    return {
      board: {
        cell00: null,
        cell01: null,
        cell02: null,
        cell10: null,
        cell11: null,
        cell12: null,
        cell20: null,
        cell21: null,
        cell22: null,
      },
    };
  },
  methods: {
    setIcon(position) {
      axios
        .post("/humanPlay", position)
        .then((response) => {
          let positionBot = response.data;
          console.log(positionBot.row);
          this.board["cell" + positionBot.row + "" + positionBot.col] =
            icon.cross;
          this.isGameOver();
        })
        .catch((error) => console.log(error));

      this.board["cell" + position.row + "" + position.col] = icon.circle;
    },
    isGameOver() {
      axios
        .get("/isGameOver")
        .then((response) => {
          console.log("El ganador es: " + response.data);
        })
        .catch((error) => console.log(error));
    },
  },
};
</script>