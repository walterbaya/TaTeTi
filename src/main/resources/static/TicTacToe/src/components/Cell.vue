<template>
    <div>
        <img v-bind:src="this.image" alt="">
    </div>
</template>

<script>

export default {
    name: 'Cell',
    props: {
        image: String
    }
}
</script>