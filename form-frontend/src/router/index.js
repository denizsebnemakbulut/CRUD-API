import Vue from 'vue'
import VueRouter from 'vue-router'
import Dashboard from '../views/Dashboard.vue'
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import PersonDetail from "../views/PersonDetail.vue";

Vue.use(VueRouter)

const routes = [{
        path: '/',
        name: 'Dashboard',
        component: Dashboard,
        children: [{
                path: '/home',
                name: 'Home',
                component: Home
            },
            {
                path: '/about',
                name: 'About',
                component: About
            },
            {
                path: "/person/:id",
                name: "person_detail",
                component: PersonDetail
            },
            {
                path: "/create_person",
                name: "create_person",
                component: function() {
                    return import ("../views/PersonCreate.vue");
                }
            }
        ]
    }

]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router