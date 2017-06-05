import VueRouter from 'vue-router';
import Vue from 'vue';
import App from './App.vue';
import routes from './router';

import Form from './utilities/Form';
window.Form = Form;
window.base_url = "http://5.196.1.134:3000/"


Vue.use(VueRouter);

const router = new VueRouter({
    mode: 'history',
    scrollBehavior: () => ({ y: 0 }),
    routes,
    linkActiveClass: 'active'
});

new Vue({
    router,
    render: h => h(App)
}).$mount('#app');




