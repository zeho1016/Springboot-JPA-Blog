let index = {
	init: function(){
		$("#btn-save").on("click",()=>{  // function(){}, ()=>{} this를 바인딩 하기위해 사용
			this.save();
		});
		$("#btn-delete").on("click",()=>{  // function(){}, ()=>{} this를 바인딩 하기위해 사용
			this.deleteById();
		});
		$("#btn-update").on("click",()=>{  // function(){}, ()=>{} this를 바인딩 하기위해 사용
			this.update();
		});
		$("#btn-reply-save").on("click",()=>{  // function(){}, ()=>{} this를 바인딩 하기위해 사용
			this.replySave();
		});
		$("#btn-reply-delete").on("click",()=>{  // function(){}, ()=>{} this를 바인딩 하기위해 사용
			this.replyDelete();
		});
	
	},
	
	
	 save:function(){
		let data = {
			title:$("#title").val(),
			content:$("#content").val()
		};
	
		$.ajax({
			type:"POST",
			url:"/api/board",
			data:JSON.stringify(data), //http body데이터
			contentType:"application/json;charset=utf-8", // body데이터의 타입
			dataType:"json" // 요청의 결과를 문자열에서 javascript object로 변환
		}).done(function(resp){
			alert("글쓰기가 완료되었습니다.");
			//console.log(resp);
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); // ajax 통신을 이용해 3개의 데이터를 json으로 변경하여 insert 요청!
	},
		
	deleteById:function(){
		let id = $("#id").text();
	
		$.ajax({
			type:"DELETE",
			url:"/api/board/"+id,
			dataType:"json" // 요청의 결과를 문자열에서 javascript object로 변환
		}).done(function(resp){
			alert("글 삭제가 완료되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); // ajax 통신을 이용해 3개의 데이터를 json으로 변경하여 insert 요청!
		
	},
	
	 update:function(){
		 	let id =$("#id").val();
		 
			let data = {
				title:$("#title").val(),
				content:$("#content").val()
			};
		
			$.ajax({
				type:"PUT", //update
				url:"/api/board/"+id,
				data:JSON.stringify(data), //http body데이터
				contentType:"application/json;charset=utf-8", // body데이터의 타입
				dataType:"json" // 요청의 결과를 문자열에서 javascript object로 변환
			}).done(function(resp){
				alert("글수정이 완료되었습니다.");
				//console.log(resp);
				location.href="/";
			}).fail(function(error){
				alert(JSON.stringify(error));
			}); // ajax 통신을 이용해 3개의 데이터를 json으로 변경하여 insert 요청!
		},
		
		replySave:function(){
			let data = {
					boardId:$("#boardId").val(),
					userId:$("#userId").val(),
					content:$("#reply-content").val()
			};
			
			
			
			$.ajax({
				type:"POST", //update
				url:`/api/board/${data.boardId}/reply`,
				data:JSON.stringify(data), //http body데이터
				contentType:"application/json;charset=utf-8", // body데이터의 타입
				dataType:"json" // 요청의 결과를 문자열에서 javascript object로 변환
			}).done(function(resp){
				alert("댓글작성이 완료되었습니다.");
				//console.log(resp);
				location.href=`/board/${data.boardId}`;
			}).fail(function(error){
				alert(JSON.stringify(error));
			}); // ajax 통신을 이용해 3개의 데이터를 json으로 변경하여 insert 요청!
		},
		
		replyDelete:function(boadId, replyId){
			$.ajax({
				type:"DELETE",
				url:`/api/board/${boardId}/reply/{replyId}`,
				dataType:"json" // 요청의 결과를 문자열에서 javascript object로 변환
			}).done(function(resp){
				alert("글 삭제가 완료되었습니다.");
				location.href=`/board/${boardId}`;
			}).fail(function(error){
				alert(JSON.stringify(error));
			}); // ajax 통신을 이용해 3개의 데이터를 json으로 변경하여 insert 요청!
			
		},
	
}

index.init();