import App from  './App.vue'

export default [
    {
        path: '/',
        component: App.components.zakazivanje,
        name: 'index'
    },
    {
        path: '/zakazivanje',
        component: App.components.zakazivanje,
        name: 'zakazivanje'
    },
    {
        path: '/raspored',
        redirect: '/raspored/sala/Tempus/nedelja/1'
    },
    {
        path: '/raspored/sala/:sala/nedelja/:nedelja',
        component: App.components.raspored,
        name: 'raspored'
    }
]
