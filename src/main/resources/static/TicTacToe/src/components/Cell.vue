<template>
    <div>
        <img v-bind:src="getImage()" alt="">
    </div>
</template>

<script>

import circle from "../assets/img/circle.png";
import cross from "../assets/img/cross.png";


export default {
    name: 'Cell',
    props: {
        position: Object,
        image: String
    },
    methods: {
        getImage(){
           console.log(circle);
           return circle;
        } 
    },
    data() {
        return {
            pressed: false
        }
    },
}
</script>