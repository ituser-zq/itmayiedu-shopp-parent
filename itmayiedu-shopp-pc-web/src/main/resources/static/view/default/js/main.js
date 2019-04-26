$(function(){
	$(".menu-mainnav li").each(function(){
		$(this).mouseover(function(){
			$(".menu-subnav .navsonbox").eq($(this).index()).addClass("on").fadeIn().siblings().removeClass("on").fadeOut();
		});
	});
	$(".menu-subnav").mouseleave(function(){
		$(".menu-subnav .navsonbox").hide();
	})
});
 //将时间减去1秒，计算天、时、分、秒
function SetRemainTime(n) { 
	//n = n || '';
	var SysSecond = parseInt($("#time"+n).data("time"));
	if (SysSecond > 0) { 
   		SysSecond = SysSecond - 1; 
   		var second = Math.floor(SysSecond % 60);           // 计算秒     
   		var minute = Math.floor((SysSecond / 60) % 60);    //计算分 
   		var hour = Math.floor((SysSecond / 3600) % 24);    // 计算时
   		var day=Math.floor((SysSecond / 86400));      //计算天
   		$("#v_hour"+n).html( hour);
   		$("#v_minute"+n).html( minute);
   		$("#v_second"+n).html( second); 
   		$("#v_day"+n).html(day)
   		$("#time"+n).data("time", SysSecond);
  	} else {//剩余时间小于或等于0的时候，就停止间隔函数 
   		/* window.clearInterval(InterValObj+n);  */
   		//这里可以添加倒计时时间为0后需要执行的事件 
  	} 
}
//fenge

var domain = '//' + window.location.host; //默认域名
//从url中获取参数
function getParam(paramName) {
	var p = "";
	if(this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=") > 1) {
		var arr = decodeURIComponent(this.location.search).substring(1, this.location.search.length).split("&");
		$.each(arr, function(k, v) {
			if(v.indexOf("=") > 0 && v.split("=")[0].toLowerCase() == paramName.toLowerCase()) {
				p = v.split("=")[1];
				return false;
			}
		});
	}
	return p;
}

$(function() {
	var ishover = false;
	$(".all-part-nav").hover(function() {
		$(".ny-menu-box").show();
		$(".menu-box").css({
			"width": "100%",
			"display": "block"
		});
		$(".navbar-hover").show();
	}, function(e) {
		setTimeout(function() {
			if(ishover==false){
				$(".ny-menu-box").trigger("mouseleave");
			}
		}, 0);
	});
	$(".ny-menu-box").mouseover(function() {
		ishover = true;
	}).mouseleave(function() {
		$(this).hide();
		ishover = false;
	});
	$('.totop').click(function() {
		$('html,body').animate({
			scrollTop: '0px'
		}, 300);
	});
	$(".nav-pic-menu li:first-child").css("border-top", "none");
	$(".nav-pic-menu li:last-child").css("border-bottom", "none");
	$(".nav-pic-menu li").each(function() {
		$(this).mouseover(function() {
			$(this).prev().css("border-bottom-color", "#fff");
			$(this).next().css("border-top-color", "#fff");
			$(this).css("border-color", "#fff");
			$(".navbar-hover").show();
		});
		$(this).mouseleave(function() {
			$(this).prev().css("border-bottom-color", "#fff");
			$(this).next().css("border-top-color", "#fff");
			$(this).css("border-color", "#fff");
			$(".navbar-hover").hide();
		});
	});
	$(".nav-pic-menu li").each(function() {
		$(this).mouseover(function() {
			$(".menu-box").css("width", "100%");
		});
		$(this).mouseleave(function() {
			$(".menu-box").css("width", "250px");
		})
	});
	
	$(".select-mod a").each(function() {
		$(this).click(function() {
			$(this).addClass("selected").siblings().removeClass("selected");
			if ($(this).parents("#ym-item").length>0) {
				var spec ='';
				$("#goods-spec .it .selected").each(function() {
					spec += $(this).attr("id")+ ',';
				});
				if (spec !='') {
					spec = spec.substr(0, spec.length - 1);
				}
				$.getJSON("/item.html",{act:'get_specinfo', id:goods_id, spec:spec}, function(res) {
					$("#ym-price").html(res.data.price);
					$("#goods_num").data("max",res.data.number);
					if ($("#user_discount").val() !='') {
						$("#ym-userprice").html((res.data.goods_price * $("#user_discount").val()).toFixed(2));
					}
					
				});				
			}
			else{
				$("#ym-price").html(price);
			}
		});
	});
});

function onlyNum(t) {
	t.value = t.value.replace(/[^\d]/g, '');//  /[^\d\.]/g
}

//金额
function onlyAmount(th){
    var a = [
        ['^0(\\d+)$', '$1'], //禁止录入整数部分两位以上，但首位为0
        ['[^\\d\\.]+$', ''], //禁止录入任何非数字和点
        ['\\.(\\d?)\\.+', '.$1'], //禁止录入两个以上的点
        ['^(\\d+\\.\\d{2}).+', '$1'] //禁止录入小数点后两位以上
    ];
    for(i=0; i<a.length; i++){
        var reg = new RegExp(a[i][0]);
        th.value = th.value.replace(reg, a[i][1]);
    }
}

//英文字母
function is_en(v) {
	return /^[A-Za-z]+$/.test(v);
}

//英文字母和数字 6到20位
function is_enAndnum(v) {
	return /^[A-Za-z0-9]{6,20}$/.test(v);
}

//手机号码
function is_mobile(v) {
	return /^(13|14|15|17|18)[0-9]{9}$/.test(v);
}

//email
function is_email(v) {
	return /^(\w-*\.*)+@(\w-?)+(\.\w{2,10})+$/.test(v);
}

//固定电话
function is_tel(v) {
	return /^[0-9]{1,4}(-|[0-9])\d{5,15}$/.test(v);
}
 
//中文
function is_chinese(v) {
	return /^([\u4e00-\u9fa5])([\u4e00-\u9fa5·]){0,23}([\u4e00-\u9fa5])$/i.test(v);
} 

function is_consignee(v) {
	return /^(([\u4e00-\u9fa5])([\u4e00-\u9fa5·]){0,10}([\u4e00-\u9fa5]))|([a-zA-Z]([a-zA-Z]|\s){2,20})$/i.test(v);
}
 
//字符串长度
function getStringLength(str) {
	if(!str) {
		return;
	}
	var bytesCount = 0;
	for(var i = 0; i < str.length; i++) {
		var c = str.charAt(i);
		if(/^[\u0000-\u00ff]$/.test(c)) {
			bytesCount += 1;
		} else {
			bytesCount += 2;
		}
	}
	return bytesCount;
}

function words_deal(th) {
	var t = $(th);
	var curLength = t.val().length;
	if(curLength > 200) {
		t.val(t.val().substr(0, 200));
	} else {
		t.parent().siblings().find("em").text(200 - t.val().length);
	}
}
//全选
function checkall(t, list) {
	var checked = $(t).prop("checked");
	$(".btn-checkall").prop("checked", checked);
	$(list).find("input[type='checkbox']").each(function() {
		$(this).prop("checked", checked);
		updateStatus($(this));
	});
}

function setall(t, list) {
	if($(list).find("input[type='checkbox']:checked").length == $(list).children().length) {
		$(t).prop("checked", "checked");
	} else {
		$(t).prop("checked", "");
	}
}

function loadLayer() {
	$("body").append('<script src="view/default/js/layer.min.js"></script>');
}

//添加多个商品到购物车   多个商品Id和规格分别用-分隔, 如    1-2-3   白色-64g
function addcartMult(gid, direct, num, spec)
{
	if (gid ==undefined || gid=='') {
		msg("商品编号不能为空");
	}
	var gids = gid.split("-"), specs=spec.split("-");
	if (gids.length==0) {
		return;
	}
	for (var i = 0; i < gids.length; i++) {
		if ($.trim(gids[i])!='') {
			addCart($.trim(gids[i]), 0, num, specs[i]);
		}
	}
	if(direct && direct ==1) {
		window.location.href = '/cart.html?directbuy=1';
	}
}

//添加到购物车
function addCart(gid, direct, num, spec) {
	num = num || $("#goods_num").val();
	var spec = spec==undefined ? '' : spec;
	if (spec==0) {
		var err ='';
		spec='';
		$("#goods-spec .it").each(function() {
			if ($(this).find(".selected").length==0) {
				err += "请选择 " + $(this).children(".spec-name").html()+"<br>";				
			}
			else{
				spec +=$(this).find(".selected").attr("id")+',';
			}
		});
		if (err !='') {
			msg(err);
			return;
		}
		if (spec!='') {
			spec =spec.substr(0, spec.length-1);
		}
	}
	var data = {
		act: 'addtocart',
		gid: gid,
		spec: spec,
		type: 1,
		num: num,
		direct:direct
	};
	
	$.getJSON("/cart.html", data, function(res) {
		if(res && res.url) {
			window.location.href = res.url;
			return;
		}
		if(res.err && res.err != '') {
			msg('加入购物车失败，' + res.err);
		} else {
			$(".cartinfo").html(res.res);
			msg('已加入购物车');
			if(direct && direct ==1) {
				window.location.href = '/order.html?directbuy=1';
			}
		}
	});
}

function removeGoods(ids, spec) {
		$.getJSON("/cart.html", {
			act: 'remove_goods',
			gid: ids,
			spec: spec
		}, function(res) {
			if(res.err != '') {
				msg("删除失败，" + res.err);
			} else {
				msg("删除成功");
				$(".cartinfo").html(res.res);
				var list = ids.split("@");
				$.each(list, function(k, v) {
					$("#" + v).remove();
				});
				
				sumShopping();
			}
	});
}

//更新已选数目
function sumShopping() {
	var n = 0,p = 0;
	if ($("#list input[name='chk_list']").length>0) {				
		$("#list input[name='chk_list']:checked").each(function() {
			n += parseFloat($(this).parent().siblings(".btn-add-reduce").children(".result").val());
			p += parseFloat($(this).parent().siblings(".cart-five").children(".subtotal").html())
		});	
	} 
	else{
		$("#cart-list li").each(function() {
			n += parseInt($(this).find("span.mincart-num").html());
			p += parseFloat($(this).find("span.mincart-price").html()) * parseInt($(this).find("span.mincart-num").html());
		});
	}
	
	$("#selectnum").html(n);
	$("#total").html(p.toFixed(2));	
	$("#cart-total").html(p.toFixed(2));
}

//计算=数量
function computeNum(obj, isPlus) {
	var txtNum = (isPlus == "" ? obj : obj.siblings(".result"));
	var max = txtNum.data("max");
	var n = parseInt(txtNum.val());
	//n = n==NaN ? 1:n;
	max = max || 9999;
	if(isPlus != undefined && isPlus == "add" && n <= max) {
		n++;
	} else if(isPlus != undefined && isPlus == "reduce" && n > 1) {
		n--;
	}
	if(n > max) {
		n = max;
		msg(txtNum.data("msg")? txtNum.data("msg"):"抱歉，库存只有" + n + "件");
	}
	if(n < 1) {
		n = 1;
	}
	txtNum.val(n);
}

$(function() {
	//购买数量
	$(".add").click(function() {
		computeNum($(this), "add");
		$(this).siblings(".result").trigger("change");
	});
	$(".reduce").click(function() {
		computeNum($(this), "reduce");
		$(this).siblings(".result").trigger("change");
	});
	$(".result").keyup(function() {
		computeNum($(this), "");
	});
	
	$(".elli").each(function(i) {
		var divH = $(this).height();
		var $p = $("p", $(this)).eq(0);
		while($p.outerHeight() > divH) {
			$p.text($p.text().replace(/(\s)*([a-zA-Z0-9]+|\W)(\.\.\.)?$/, "..."));
		};
	});
	
	//价格
	$("#btnprice").click(function() {
		var m = $.trim($("#price-min").val()),
			l = $.trim($("#price-max").val());
		m = m == '' ? 0 : parseInt(m);
		l = l == '' ? 0 : parseInt(l);
		if(m == 0 && l == 0) {
			return;
		}
		var href = window.location.href;
		var list = href.split('&');
		var newurl = '';
		if(href.indexOf("pr=") == -1) {
			newurl = href + (href.indexOf("?") == -1 ? "?" : "&") + "pr=" + m + "-" + l
		} else {
			$.each(list, function(k, v) {
				if(v.indexOf("pr=") == 0) {
					newurl += "pr=" + m + "-" + l;
				} else {
					newurl += list[k] + "&";
				}
			});
		}
		window.location.href = newurl;
	});
	
	//购物车
	$(".web-title-container .cartbox").mouseover(function() {		
		show_cartinfo($(this));	
	});	
	
	$(".cart-slidedown").mouseover(function(e) {
		e.stopPropagation();	
	});
		
	var carthtml= $(".cart-slidedownbox ul").html();
	$(".cart-slidedownbox ul").html("");
	function show_cartinfo(t) {
		$.getJSON("/cart.html", {act: 'get_cart'}, function(res) {
			if(res.err && res.err != '') {
				
			} else {
				$(".cartinfo").html(res.data.num);
				$("#cart-total").html(res.data.amount);
				var $html='';	
				if (res.data !=false) {					
					$.each(res.data.goods, function(k, v) {
						$html += carthtml;
						$html = $html.replace(/\[goods_id\]/g, v.goods_id).replace(/\[spec_name\]/g, v.spec_name).replace(/\[url\]/g, v.url).replace(/\[name\]/g, v.name).replace(/\[thumb\]/g, v.thumb).replace(/\[price\]/g, v.price).replace(/\[num\]/g, v.num);
					}); 
				}
				
				$(".cart-slidedownbox ul").html($html); 
				$(".slidecart-js").attr("href", res.data.num >0 ?"/cart.html":"javascript:void(0);")
				 
				//移除商品
				$(".delgoods").each(function() {
					$(this).click(function() {
						var p = $(this).parents("li");
						var ids = p.attr("id"),spec = p.data("spec");
						removeGoods(ids, spec);
					});
				});
			}
		});
	}
	  
});

$(".btn-search").click(function() {
	if ($.trim($("#word").val()) =='') {
		return false;
	}
});

//取消订单
function order_cancel(oid) {
    top.layer.confirm('确定要取消该订单吗？', function(index) {
        $.getJSON("./order.html", {
            act: 'order_cancel',
            oid: oid
        }, function(res) {
            if (res.err && res.err != '') {
                msg('取消失败，' + res.err);
                return;
            }
            if (res.url && res.url != '') {
                window.location.href = res.url;
                return;
            } else {
                msg('取消成功');
                setTimeout(function() {
                    window.location.reload();
                }, 1500);
            }
        });
        top.layer.close(index);
    });
}

//确认收货
function confirm_receiving(oid) {
	if (!oid) {
		return;
	}
	layer.confirm('请确认是否已收到货？', function(index) {
		$.getJSON("/order.html", {act:'confirm_receiving', oid:oid}, function(res) {
			if(res.err && res.err != '') {
				msg('操作失败，' + res.err);return;
			}
			if(res.url && res.url != '') {
				window.location.href = res.url; return;
			}
			else
			{
				msg('您已确认收货');
				setTimeout(function() {
					window.location.reload();
				},2000);			
			}
		});
		top.layer.close(index);
	});
}

//验证码倒数
function countDown(el,wait){
    var util = {
        wait: wait || 60,
        hsTime: function(that) {
            var _this = this;
			if (_this.wait == 0) {
				$(el).removeAttr("disabled").val('获取验证码');
					_this.wait = 60;
			} else {
				$(that).attr("disabled", true).val( _this.wait + '秒后重发');
				_this.wait--;
				setTimeout(function () {
				_this.hsTime(that);
			}, 1000)
		}
	}
	}
	util.hsTime(el);
	$(el).click(function(){
		util.hsTime(el);
	});
}

//发送验证码统一函数
function sendSms(t, act, mobile) {
	if (typeof(mobile)=="undefined") {
		var t = $(t);
		if(t.data("mobileid") != "undefined")
		{
			var	ipt_mobile = $("#"+t.data("mobileid"));
		}
		else
		{
			var ipt_mobile= t.siblings("#mobile");			
		}
		var mobile = $.trim(ipt_mobile.val());
	}
    
    var err = '';
    if (mobile == '') {
        err = "请输入手机号码"; 
    } else if (!is_mobile(mobile)) {
        err ="手机号码不正确";
    } 
    
    if (err != '') {
    	msg(err);
    	if(ipt_mobile) {
    		ipt_mobile.focus();
    	}
    }
    
    $.getJSON("user_api.html", {
        act: act,
        mobile: mobile
    },
    function(res) {
        if (res.err && res.err != '') {
            msg("发送失败，" + res.err, 4000);
            return;
        } else {
            msg("验证码已发送，10分钟内有效");
            return;
        }
    });
};

//获取cookies函数   name:cookie名字 
 
function getCookie(name){  
    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));  
    if(arr != null){  
     return unescape(arr[2]);   
    }else{  
     return null;  
    }  
} 

//检测手机是否存在
function check_mobile(mobile, callback) {
	$.getJSON("user_api.html", {act:'check_mobile',mobile:mobile}, function(res){
		if (typeof callback === "function"){
			callback(res); 
		};							
	});
}

//验证当前手机
function check_cur_mobile(mobile, smscode, callback) {
	$.getJSON("user_api.html", {act:'check_cur_mobile',mobile:mobile,smscode:smscode}, function(res){
		if (typeof callback === "function"){
			callback(res); 
		};							
	});
}

//领取优惠券
function receive_coupon(coupon_id, btn) {
	$.getJSON("quan.html", {act:'receive_coupon',coupon_id:coupon_id}, function(res){
		if (typeof callback === "function"){
			callback(res); 
		}
		else
		{
			if(res.url) {
				window.location.href = res.url;return;
			}
			else if(res.err && res.err !='') {
				msg("领取失败，" + res.err);return;
			}
			msg("领取成功", 5000);
			btn.replaceWith('<i class="quan-ico quan-geted"></i>');
		}
	});
}
//领取优惠券
$(".couponlist").on("click", ".getcoupon", function() {
	receive_coupon($(this).data("id"), $(this));
});
