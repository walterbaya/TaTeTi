<template>
    <div>
        <img v-bind:src="getImage" alt="">
    </div>
</template>

<script>
export default {
    name: 'Cell',
    props: {
        cell_number: Number,
        draw: String
    },
    methods: {
        getImage(){
            console.log(require('../assets/img/' + draw + '.png'));
            return require('../assets/img/' + draw + '.png');
        } 
    },
    data() {
        return {
            pressed: false
        }
    },
}
</script>