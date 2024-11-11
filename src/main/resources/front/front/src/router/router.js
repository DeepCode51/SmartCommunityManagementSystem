import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import yezhuxinxiList from '../pages/yezhuxinxi/list'
import yezhuxinxiDetail from '../pages/yezhuxinxi/detail'
import yezhuxinxiAdd from '../pages/yezhuxinxi/add'
import yuangongList from '../pages/yuangong/list'
import yuangongDetail from '../pages/yuangong/detail'
import yuangongAdd from '../pages/yuangong/add'
import fangwuxinxiList from '../pages/fangwuxinxi/list'
import fangwuxinxiDetail from '../pages/fangwuxinxi/detail'
import fangwuxinxiAdd from '../pages/fangwuxinxi/add'
import juminxinxiList from '../pages/juminxinxi/list'
import juminxinxiDetail from '../pages/juminxinxi/detail'
import juminxinxiAdd from '../pages/juminxinxi/add'
import chongdianzhuangList from '../pages/chongdianzhuang/list'
import chongdianzhuangDetail from '../pages/chongdianzhuang/detail'
import chongdianzhuangAdd from '../pages/chongdianzhuang/add'
import chongdianzhuangyuyueList from '../pages/chongdianzhuangyuyue/list'
import chongdianzhuangyuyueDetail from '../pages/chongdianzhuangyuyue/detail'
import chongdianzhuangyuyueAdd from '../pages/chongdianzhuangyuyue/add'
import xiaoquxinxiList from '../pages/xiaoquxinxi/list'
import xiaoquxinxiDetail from '../pages/xiaoquxinxi/detail'
import xiaoquxinxiAdd from '../pages/xiaoquxinxi/add'
import wuyejiaofeiList from '../pages/wuyejiaofei/list'
import wuyejiaofeiDetail from '../pages/wuyejiaofei/detail'
import wuyejiaofeiAdd from '../pages/wuyejiaofei/add'
import laifangdengjiList from '../pages/laifangdengji/list'
import laifangdengjiDetail from '../pages/laifangdengji/detail'
import laifangdengjiAdd from '../pages/laifangdengji/add'
import wuyebaoxiuList from '../pages/wuyebaoxiu/list'
import wuyebaoxiuDetail from '../pages/wuyebaoxiu/detail'
import wuyebaoxiuAdd from '../pages/wuyebaoxiu/add'
import weixiuqingdanList from '../pages/weixiuqingdan/list'
import weixiuqingdanDetail from '../pages/weixiuqingdan/detail'
import weixiuqingdanAdd from '../pages/weixiuqingdan/add'
import weixiupingjiaList from '../pages/weixiupingjia/list'
import weixiupingjiaDetail from '../pages/weixiupingjia/detail'
import weixiupingjiaAdd from '../pages/weixiupingjia/add'
import zhihuimenjinList from '../pages/zhihuimenjin/list'
import zhihuimenjinDetail from '../pages/zhihuimenjin/detail'
import zhihuimenjinAdd from '../pages/zhihuimenjin/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'messages',
					component: Messages
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yezhuxinxi',
					component: yezhuxinxiList
				},
				{
					path: 'yezhuxinxiDetail',
					component: yezhuxinxiDetail
				},
				{
					path: 'yezhuxinxiAdd',
					component: yezhuxinxiAdd
				},
				{
					path: 'yuangong',
					component: yuangongList
				},
				{
					path: 'yuangongDetail',
					component: yuangongDetail
				},
				{
					path: 'yuangongAdd',
					component: yuangongAdd
				},
				{
					path: 'fangwuxinxi',
					component: fangwuxinxiList
				},
				{
					path: 'fangwuxinxiDetail',
					component: fangwuxinxiDetail
				},
				{
					path: 'fangwuxinxiAdd',
					component: fangwuxinxiAdd
				},
				{
					path: 'juminxinxi',
					component: juminxinxiList
				},
				{
					path: 'juminxinxiDetail',
					component: juminxinxiDetail
				},
				{
					path: 'juminxinxiAdd',
					component: juminxinxiAdd
				},
				{
					path: 'chongdianzhuang',
					component: chongdianzhuangList
				},
				{
					path: 'chongdianzhuangDetail',
					component: chongdianzhuangDetail
				},
				{
					path: 'chongdianzhuangAdd',
					component: chongdianzhuangAdd
				},
				{
					path: 'chongdianzhuangyuyue',
					component: chongdianzhuangyuyueList
				},
				{
					path: 'chongdianzhuangyuyueDetail',
					component: chongdianzhuangyuyueDetail
				},
				{
					path: 'chongdianzhuangyuyueAdd',
					component: chongdianzhuangyuyueAdd
				},
				{
					path: 'xiaoquxinxi',
					component: xiaoquxinxiList
				},
				{
					path: 'xiaoquxinxiDetail',
					component: xiaoquxinxiDetail
				},
				{
					path: 'xiaoquxinxiAdd',
					component: xiaoquxinxiAdd
				},
				{
					path: 'wuyejiaofei',
					component: wuyejiaofeiList
				},
				{
					path: 'wuyejiaofeiDetail',
					component: wuyejiaofeiDetail
				},
				{
					path: 'wuyejiaofeiAdd',
					component: wuyejiaofeiAdd
				},
				{
					path: 'laifangdengji',
					component: laifangdengjiList
				},
				{
					path: 'laifangdengjiDetail',
					component: laifangdengjiDetail
				},
				{
					path: 'laifangdengjiAdd',
					component: laifangdengjiAdd
				},
				{
					path: 'wuyebaoxiu',
					component: wuyebaoxiuList
				},
				{
					path: 'wuyebaoxiuDetail',
					component: wuyebaoxiuDetail
				},
				{
					path: 'wuyebaoxiuAdd',
					component: wuyebaoxiuAdd
				},
				{
					path: 'weixiuqingdan',
					component: weixiuqingdanList
				},
				{
					path: 'weixiuqingdanDetail',
					component: weixiuqingdanDetail
				},
				{
					path: 'weixiuqingdanAdd',
					component: weixiuqingdanAdd
				},
				{
					path: 'weixiupingjia',
					component: weixiupingjiaList
				},
				{
					path: 'weixiupingjiaDetail',
					component: weixiupingjiaDetail
				},
				{
					path: 'weixiupingjiaAdd',
					component: weixiupingjiaAdd
				},
				{
					path: 'zhihuimenjin',
					component: zhihuimenjinList
				},
				{
					path: 'zhihuimenjinDetail',
					component: zhihuimenjinDetail
				},
				{
					path: 'zhihuimenjinAdd',
					component: zhihuimenjinAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
