let index = {
	init: function(){
		$("#btn-save").on("click",()=>{  // function(){}, ()=>{} this를 바인딩 하기위해 사용
			this.save();
		});
		/*$("#btn-login").on("click",()=>{  // function(){}, ()=>{} this를 바인딩 하기위해 사용
			this.login();
		});*/
		$("#btn-update").on("click",()=>{  // function(){}, ()=>{} this를 바인딩 하기위해 사용
			this.update();
		});
		
	},
	
	 save:function(){
		//alert("user의 save함수 호출됨");
		let data = {
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val()
		};
		
		//console.log(data);
		
		// ajax호출시 default가 비동기
		// ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
		// ajax가 통신을 성공하고 json을 리턴해주면 자동으로 자바 오브젝트로 변환
		$.ajax({
			// 회원가입 수행요청
			type:"POST",
			url:"/auth/joinProc",
			data:JSON.stringify(data), //http body데이터
			contentType:"application/json;charset=utf-8", // body데이터의 타입
			dataType:"json" // 요청의 결과를 문자열에서 javascript object로 변환
		}).done(function(resp){
			alert("회원가입이 완료되었습니다.");
			//console.log(resp);
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); // ajax 통신을 이용해 3개의 데이터를 json으로 변경하여 insert 요청!
	},
	
	update:function(){
		
		
		let data = {
			id:$("#id").val(),
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val()
		};
		
		$.ajax({
			// 회원가입 수행요청
			type:"PUT",
			url:"/user",
			data:JSON.stringify(data), //http body데이터
			contentType:"application/json;charset=utf-8", // body데이터의 타입
			dataType:"json" // 요청의 결과를 문자열에서 javascript object로 변환
		}).done(function(resp){
			alert("회원수정이 완료되었습니다.");
			//console.log(resp);
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); // ajax 통신을 이용해 3개의 데이터를 json으로 변경하여 insert 요청!
	}
	/*
	 login:function(){
		//alert("user의 save함수 호출됨");
		let data = {
			username:$("#username").val(),
			password:$("#password").val()
		};
		
		$.ajax({
			// 로그인 수행요청
			type:"POST",
			url:"/api/user/login",
			data:JSON.stringify(data), //http body데이터
			contentType:"application/json;charset=utf-8", // body데이터의 타입
			dataType:"json" // 요청의 결과를 문자열에서 javascript object로 변환
		}).done(function(resp){
			alert("로그인이 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); // ajax 통신을 이용해 3개의 데이터를 json으로 변경하여 insert 요청!
	},*/
}

index.init();