<template>
<div :style='{"border":"2px solid #a4d9b7","padding":"20px","margin":"20px auto 0","borderRadius":"8px","flexWrap":"wrap","background":"#fff","width":"1200px","position":"relative"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="200px"
    >
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}'  label="月份" prop="yuefen">
            <el-select v-model="ruleForm.yuefen" placeholder="请选择月份"  >
              <el-option
                  v-for="(item,index) in yuefenOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="业主账号" prop="yezhuzhanghao">
            <el-select  @change="yezhuzhanghaoChange" v-model="ruleForm.yezhuzhanghao" placeholder="请选择业主账号">
              <el-option
                  v-for="(item,index) in yezhuzhanghaoOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="业主姓名" prop="yezhuxingming">
            <el-input v-model="ruleForm.yezhuxingming" 
                placeholder="业主姓名" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="楼栋" prop="loudong">
            <el-input v-model="ruleForm.loudong" 
                placeholder="楼栋" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="房号" prop="fanghao">
            <el-input v-model="ruleForm.fanghao" 
                placeholder="房号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="水费" prop="shuifei">
            <el-input v-model="ruleForm.shuifei" 
                placeholder="水费" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="电费" prop="dianfei">
            <el-input v-model="ruleForm.dianfei" 
                placeholder="电费" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="物业费" prop="wuyefei">
            <el-input v-model="ruleForm.wuyefei" 
                placeholder="物业费" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="总费用" prop="zongfeiyong">
              <el-input v-model="zongfeiyong" placeholder="总费用" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"100%","padding":"10px","margin":"0 0 0px","display":"inline-block"}' label="发布时间" prop="fabushijian" >
              <el-date-picker
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.fabushijian" 
                  type="datetime"
                  placeholder="发布时间">
              </el-date-picker>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"8px 0 0 0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"20px 40px 20px 260px","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"20px","background":"#47b144","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"2px solid #3db769","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#3db769","borderRadius":"20px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            yuefen : false,
            yezhuzhanghao : false,
            yezhuxingming : false,
            loudong : false,
            fanghao : false,
            shuifei : false,
            dianfei : false,
            wuyefei : false,
            zongfeiyong : false,
            fabushijian : false,
            ispay : false,
            userid : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          yuefen: '',
          yezhuzhanghao: '',
          yezhuxingming: '',
          loudong: '',
          fanghao: '',
          shuifei: '',
          dianfei: '',
          wuyefei: '',
          zongfeiyong: '',
          fabushijian: '',
          ispay: '',
          userid: '',
        },
        yuefenOptions: [],
        yezhuzhanghaoOptions: [],
        rules: {
          yuefen: [
          ],
          yezhuzhanghao: [
          ],
          yezhuxingming: [
          ],
          loudong: [
          ],
          fanghao: [
          ],
          shuifei: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          dianfei: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          wuyefei: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          zongfeiyong: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          fabushijian: [
          ],
          ispay: [
          ],
          userid: [
          ],
        },
      };
    },
    computed: {
        zongfeiyong: {
            get: function () {
                return 0+parseFloat(this.ruleForm.shuifei==""?0:this.ruleForm.shuifei)+parseFloat(this.ruleForm.dianfei==""?0:this.ruleForm.dianfei)+parseFloat(this.ruleForm.wuyefei==""?0:this.ruleForm.wuyefei) || 0
            }
        },



    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.fabushijian = this.getCurDateTime()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='yuefen'){
              this.ruleForm.yuefen = obj[o];
              this.ro.yuefen = true;
              continue;
            }
            if(o=='yezhuzhanghao'){
              this.ruleForm.yezhuzhanghao = obj[o];
              this.ro.yezhuzhanghao = true;
              continue;
            }
            if(o=='yezhuxingming'){
              this.ruleForm.yezhuxingming = obj[o];
              this.ro.yezhuxingming = true;
              continue;
            }
            if(o=='loudong'){
              this.ruleForm.loudong = obj[o];
              this.ro.loudong = true;
              continue;
            }
            if(o=='fanghao'){
              this.ruleForm.fanghao = obj[o];
              this.ro.fanghao = true;
              continue;
            }
            if(o=='shuifei'){
              this.ruleForm.shuifei = obj[o];
              this.ro.shuifei = true;
              continue;
            }
            if(o=='dianfei'){
              this.ruleForm.dianfei = obj[o];
              this.ro.dianfei = true;
              continue;
            }
            if(o=='wuyefei'){
              this.ruleForm.wuyefei = obj[o];
              this.ro.wuyefei = true;
              continue;
            }
            if(o=='zongfeiyong'){
              this.ruleForm.zongfeiyong = obj[o];
              this.ro.zongfeiyong = true;
              continue;
            }
            if(o=='fabushijian'){
              this.ruleForm.fabushijian = obj[o];
              this.ro.fabushijian = true;
              continue;
            }
            if(o=='userid'){
              this.ruleForm.userid = obj[o];
              this.ro.userid = true;
              continue;
            }
          }
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.yuefen!=''&&json.yuefen) || json.yuefen==0){
                this.ruleForm.yuefen = json.yuefen
            }
            if((json.yezhuzhanghao!=''&&json.yezhuzhanghao) || json.yezhuzhanghao==0){
                this.ruleForm.yezhuzhanghao = json.yezhuzhanghao
            }
            if((json.yezhuxingming!=''&&json.yezhuxingming) || json.yezhuxingming==0){
                this.ruleForm.yezhuxingming = json.yezhuxingming
            }
          }
        });
        this.yuefenOptions = "1月份,2月份,3月份,4月份,5月份,6月份,7月份,8月份,9月份,10月份,11月份,12月份".split(',')
        this.$http.get('option/yezhuxinxi/yezhuzhanghao', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.yezhuzhanghaoOptions = res.data.data;
          }
        });
      },
      // 下二随
      yezhuzhanghaoChange () {
        this.$http.get('follow/yezhuxinxi/yezhuzhanghao?columnValue=' + this.ruleForm.yezhuzhanghao, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            if(res.data.data.yezhuxingming){
              this.ruleForm.yezhuxingming = res.data.data.yezhuxingming
            }
            if(res.data.data.loudong){
              this.ruleForm.loudong = res.data.data.loudong
            }
            if(res.data.data.fanghao){
              this.ruleForm.fanghao = res.data.data.fanghao
            }
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('wuyejiaofei/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

          this.ruleForm.zongfeiyong = this.zongfeiyong
        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('wuyejiaofei/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post('wuyejiaofei/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: '操作成功',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post('wuyejiaofei/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: '操作成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
                      }
                  });
             }
          }
        });
      },
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
      // 返回
      back() {
        this.$router.go(-1);
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 200px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 200px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #9ce0b5;
	  border-radius: 4px;
	  padding: 0 12px;
	  box-shadow: inset 0px 0px 48px 0px #cef1db;
	  outline: none;
	  color: #666;
	  width: 80%;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #9ce0b5;
	  border-radius: 4px;
	  padding: 0 10px;
	  box-shadow: inset 0px 0px 48px 0px #cef1db;
	  outline: none;
	  color: #666;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #9ce0b5;
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  box-shadow: inset 0px 0px 48px 0px #cef1db;
	  outline: none;
	  color: #666;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  border: 1px solid #9ce0b5;
	  cursor: pointer;
	  border-radius: 6px;
	  box-shadow: inset 0px 0px 48px 0px #cef1db;
	  color: #3db769;
	  width: 200px;
	  font-size: 32px;
	  line-height: 120px;
	  text-align: center;
	  height: auto;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px solid #9ce0b5;
	  cursor: pointer;
	  border-radius: 6px;
	  box-shadow: inset 0px 0px 48px 0px #cef1db;
	  color: #3db769;
	  width: 200px;
	  font-size: 32px;
	  line-height: 120px;
	  text-align: center;
	  height: auto;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px solid #9ce0b5;
	  cursor: pointer;
	  border-radius: 6px;
	  box-shadow: inset 0px 0px 48px 0px #cef1db;
	  color: #3db769;
	  width: 200px;
	  font-size: 32px;
	  line-height: 120px;
	  text-align: center;
	  height: auto;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #9ce0b5;
	  border-radius: 4px;
	  padding: 12px;
	  box-shadow: inset 0px 0px 48px 0px #cef1db;
	  outline: none;
	  color: #666;
	  width: 80%;
	  font-size: 14px;
	  min-height: 180px;
	}
</style>
