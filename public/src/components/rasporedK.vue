<template>
    <form @submit.prevent="onSubmit">
        <textarea v-model="form.body"></textarea>
        <button>Caaooo</button>
    </form>
</template>

<script>

    import Form from '../utilities/Form.js'
    export default {
        name: 'rasporedK',
        data: function() {
            return {
                form: new Form({
                    body: ''
                })
            }
        },
        methods: {
            onSubmit() {
                var self = this;
                $.getJSON("src/data/statuses.json", function(result){})
                    .then(result => this.$emit('completed', result));
                //this.form.post('src/data/statuses.json');//.then(status => this.$emit('completed', status);
                //    alert("Done")
                //);


            }
        }
    }
</script>