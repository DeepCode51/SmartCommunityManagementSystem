const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootjcmah/",
            name: "springbootjcmah",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootjcmah/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "智慧社区管理系统"
        } 
    }
}
export default base
