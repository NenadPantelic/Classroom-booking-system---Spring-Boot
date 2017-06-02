<template>


    <div class="ui grid">
        <div class="computer tablet only row">
            <div class="ui fixed menu navbar grid">
                <div class="ui container">
                    <router-link class="item" to="/" exact>Претраживање</router-link>
                    <router-link class="item" to="/moj-raspored">Мој распоред</router-link>
                    <router-link class="item" to="/raspored">Распоред по салама</router-link>
                    <router-link class="item" to="/raspored-studijski-programi">Распоред за студијске програме</router-link>

                    <div class="right menu">
                        <router-link class="item" to="/login" exact>Одјава</router-link>
                    </div>
                </div>
            </div>

        </div>
        <div class="mobile only row">
            <div class="ui fixed navbar menu">
                <div class="right menu open">
                    <a href="" class="menu item">
                        <i class="content icon"></i>
                    </a>
                </div>
            </div>
            <div class="ui vertical navbar menu">
                <router-link class="item" to="/" exact>Претраживање</router-link>
                <router-link class="item" to="/moj-raspored">Мој распоред</router-link>
                <router-link class="item" to="/raspored">Распоред по салама</router-link>
                <router-link class="item" to="/raspored-studijski-programi">Распоред за студијске програме</router-link>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        mounted(){

            $('.right.menu.open').on("click",function(e){
                e.preventDefault();
                $('.ui.vertical.menu').fadeToggle();
            });
        }
    }
</script>


<style>
    .mobile.row{
        padding-top: 0px !important;
        margin-top: 0px !important;
    }
    .mobile.row .ui.menu{
        border-radius: 0px !important;
    }
    .ui.vertical.menu{
        margin-top: -15px !important;
        width: 100%;
        display: none;
    }

    @media (max-width: 767px) {
        .ui.grid {
            margin: 0 !important;
        }
        .ui.vertical.menu.navbar{
            margin-top: 40px !important;
        }
    }
</style>