import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import yuangong from '@/views/modules/yuangong/list'
    import zhihuimenjin from '@/views/modules/zhihuimenjin/list'
    import chongdianzhuangyuyue from '@/views/modules/chongdianzhuangyuyue/list'
    import wuyejiaofei from '@/views/modules/wuyejiaofei/list'
    import weixiuqingdan from '@/views/modules/weixiuqingdan/list'
    import wuyebaoxiu from '@/views/modules/wuyebaoxiu/list'
    import fangwuxinxi from '@/views/modules/fangwuxinxi/list'
    import yezhuxinxi from '@/views/modules/yezhuxinxi/list'
    import systemintro from '@/views/modules/systemintro/list'
    import chongdianzhuang from '@/views/modules/chongdianzhuang/list'
    import juminxinxi from '@/views/modules/juminxinxi/list'
    import messages from '@/views/modules/messages/list'
    import xiaoquxinxi from '@/views/modules/xiaoquxinxi/list'
    import config from '@/views/modules/config/list'
    import laifangdengji from '@/views/modules/laifangdengji/list'
    import weixiupingjia from '@/views/modules/weixiupingjia/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '社区公告',
        component: news
      }
      ,{
	path: '/yuangong',
        name: '员工',
        component: yuangong
      }
      ,{
	path: '/zhihuimenjin',
        name: '智慧门禁',
        component: zhihuimenjin
      }
      ,{
	path: '/chongdianzhuangyuyue',
        name: '充电桩预约',
        component: chongdianzhuangyuyue
      }
      ,{
	path: '/wuyejiaofei',
        name: '物业缴费',
        component: wuyejiaofei
      }
      ,{
	path: '/weixiuqingdan',
        name: '维修清单',
        component: weixiuqingdan
      }
      ,{
	path: '/wuyebaoxiu',
        name: '物业报修',
        component: wuyebaoxiu
      }
      ,{
	path: '/fangwuxinxi',
        name: '房屋信息',
        component: fangwuxinxi
      }
      ,{
	path: '/yezhuxinxi',
        name: '业主信息',
        component: yezhuxinxi
      }
      ,{
	path: '/systemintro',
        name: '系统简介',
        component: systemintro
      }
      ,{
	path: '/chongdianzhuang',
        name: '充电桩',
        component: chongdianzhuang
      }
      ,{
	path: '/juminxinxi',
        name: '居民信息',
        component: juminxinxi
      }
      ,{
	path: '/messages',
        name: '投诉建议',
        component: messages
      }
      ,{
	path: '/xiaoquxinxi',
        name: '小区信息',
        component: xiaoquxinxi
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/laifangdengji',
        name: '来访登记',
        component: laifangdengji
      }
      ,{
	path: '/weixiupingjia',
        name: '维修评价',
        component: weixiupingjia
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '系统首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
