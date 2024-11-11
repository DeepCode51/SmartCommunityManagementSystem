export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["新增","查看","修改","删除"],"menu":"业主信息","menuJump":"列表","tableName":"yezhuxinxi"}],"menu":"业主信息管理"},{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["新增","查看","修改","删除"],"menu":"员工","menuJump":"列表","tableName":"yuangong"}],"menu":"员工管理"},{"child":[{"appFrontIcon":"cuIcon-vipcard","buttons":["新增","查看","修改","删除"],"menu":"房屋信息","menuJump":"列表","tableName":"fangwuxinxi"}],"menu":"房屋信息管理"},{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["新增","查看","修改","删除","导出","导入"],"menu":"居民信息","menuJump":"列表","tableName":"juminxinxi"}],"menu":"居民信息管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["新增","查看","修改","删除"],"menu":"充电桩","menuJump":"列表","tableName":"chongdianzhuang"}],"menu":"充电桩管理"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","修改","删除","审核"],"menu":"充电桩预约","menuJump":"列表","tableName":"chongdianzhuangyuyue"}],"menu":"充电桩预约管理"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["新增","查看","修改","删除","导出","导入"],"menu":"小区信息","menuJump":"列表","tableName":"xiaoquxinxi"}],"menu":"小区信息管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["新增","查看","修改","删除"],"menu":"物业缴费","menuJump":"列表","tableName":"wuyejiaofei"}],"menu":"物业缴费管理"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["新增","查看","修改","删除"],"menu":"来访登记","menuJump":"列表","tableName":"laifangdengji"}],"menu":"来访登记管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","修改","删除","审核","维修清单"],"menu":"物业报修","menuJump":"列表","tableName":"wuyebaoxiu"}],"menu":"物业报修管理"},{"child":[{"appFrontIcon":"cuIcon-news","buttons":["查看","修改","删除"],"menu":"维修清单","menuJump":"列表","tableName":"weixiuqingdan"}],"menu":"维修清单管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["查看","修改","删除"],"menu":"维修评价","menuJump":"列表","tableName":"weixiupingjia"}],"menu":"维修评价管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["查看","修改","删除"],"menu":"智慧门禁","menuJump":"列表","tableName":"zhihuimenjin"}],"menu":"智慧门禁管理"},{"child":[{"appFrontIcon":"cuIcon-message","buttons":["查看","回复","删除"],"menu":"投诉建议","tableName":"messages"}],"menu":"投诉建议"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"},{"appFrontIcon":"cuIcon-vipcard","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"社区公告","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["查看","立即预约"],"menu":"充电桩列表","menuJump":"列表","tableName":"chongdianzhuang"}],"menu":"充电桩模块"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看"],"menu":"小区信息列表","menuJump":"列表","tableName":"xiaoquxinxi"}],"menu":"小区信息模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看","删除"],"menu":"充电桩预约","menuJump":"列表","tableName":"chongdianzhuangyuyue"}],"menu":"充电桩预约管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","支付"],"menu":"物业缴费","menuJump":"列表","tableName":"wuyejiaofei"}],"menu":"物业缴费管理"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看"],"menu":"来访登记","menuJump":"列表","tableName":"laifangdengji"}],"menu":"来访登记管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["新增","查看","修改","删除"],"menu":"物业报修","menuJump":"列表","tableName":"wuyebaoxiu"}],"menu":"物业报修管理"},{"child":[{"appFrontIcon":"cuIcon-news","buttons":["查看","审核","支付","维修评价"],"menu":"维修清单","menuJump":"列表","tableName":"weixiuqingdan"}],"menu":"维修清单管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["查看","删除"],"menu":"维修评价","menuJump":"列表","tableName":"weixiupingjia"}],"menu":"维修评价管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["新增","查看","修改","删除"],"menu":"智慧门禁","menuJump":"列表","tableName":"zhihuimenjin"}],"menu":"智慧门禁管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["查看","立即预约"],"menu":"充电桩列表","menuJump":"列表","tableName":"chongdianzhuang"}],"menu":"充电桩模块"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看"],"menu":"小区信息列表","menuJump":"列表","tableName":"xiaoquxinxi"}],"menu":"小区信息模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"业主信息","tableName":"yezhuxinxi"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
