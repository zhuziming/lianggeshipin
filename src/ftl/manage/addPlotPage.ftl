<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${indexpath}/css/boots/bootstrap.min.css">
<script src="${indexpath}/js/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
	<div class="jumbotron">
	  <h1 class="display-4">元气满满的一天</h1>
	  <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
	  <hr class="my-4">
	  <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
	  <a class="btn btn-primary btn-lg" href="${indexpath}" role="button">回前台首页</a>
	  <a class="btn btn-primary btn-lg" href="${indexpath}/manage/index.action" role="button">回后台首页</a>
	</div>
	<div class="alert alert-primary" role="alert">
	 ${animated.animatedName}
	</div>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">哪一集</th>
      <th scope="col">中文标题</th>
      <th scope="col">英文标题</th>
      <th scope="col">中文视频地址</th>
      <th scope="col">英文视频地址</th>
      <th scope="col">图片地址</th>
    </tr>
  </thead>
  <form action="${indexpath}/manage/addPlot.action">
  			<input type="hidden" name="animatedID" value="${animated.id}">
	  <tbody>
	    <tr>
	      <td><input type="number" class="form-control is-valid" name="which1"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameCh1"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameEn1"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlCh1"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlEn1"  ></td>
	      <td><input type="text" class="form-control is-valid" name="imgUrl1"  ></td>
	    </tr>
	    <tr>
	      <td><input type="number" class="form-control is-valid" name="which2"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameCh2"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameEn2"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlCh2"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlEn2"  ></td>
	      <td><input type="text" class="form-control is-valid" name="imgUrl2"  ></td>
	    </tr>
	    <tr>
	      <td><input type="number" class="form-control is-valid" name="which3"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameCh3"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameEn3"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlCh3"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlEn3"  ></td>
	      <td><input type="text" class="form-control is-valid" name="imgUrl3"  ></td>
	    </tr>
	    <tr>
	      <td><input type="number" class="form-control is-valid" name="which4"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameCh4"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameEn4"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlCh4"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlEn4"  ></td>
	      <td><input type="text" class="form-control is-valid" name="imgUrl4"  ></td>
	    </tr>
	    <tr>
	      <td><input type="number" class="form-control is-valid" name="which5"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameCh5"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameEn5"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlCh5"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlEn5"  ></td>
	      <td><input type="text" class="form-control is-valid" name="imgUrl5"  ></td>
	    </tr>
	    <tr>
	      <td><input type="number" class="form-control is-valid" name="which6"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameCh6"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameEn6"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlCh6"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlEn6"  ></td>
	      <td><input type="text" class="form-control is-valid" name="imgUrl6"  ></td>
	    </tr>
	    <tr>
	      <td><input type="number" class="form-control is-valid" name="which7"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameCh7"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameEn7"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlCh7"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlEn7"  ></td>
	      <td><input type="text" class="form-control is-valid" name="imgUrl7"  ></td>
	    </tr>
	    <tr>
	      <td><input type="number" class="form-control is-valid" name="which8"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameCh8"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameEn8"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlCh8"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlEn8"  ></td>
	      <td><input type="text" class="form-control is-valid" name="imgUrl8"  ></td>
	    </tr>
	    <tr>
	      <td><input type="number" class="form-control is-valid" name="which9"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameCh9"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameEn9"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlCh9"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlEn9"  ></td>
	      <td><input type="text" class="form-control is-valid" name="imgUrl9"  ></td>
	    </tr>
	    <tr>
	      <td><input type="number" class="form-control is-valid" name="which10"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameCh10"  ></td>
	      <td><input type="text" class="form-control is-valid" name="plotNameEn10"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlCh10"  ></td>
	      <td><input type="text" class="form-control is-valid" name="videoUrlEn10"  ></td>
	      <td><input type="text" class="form-control is-valid" name="imgUrl10"  ></td>
	    </tr>
	    <tr id="lineLast">
	      <td></td>
	      <td></td>
	      <td><button class="btn btn-primary" type="submit">提交</button></td>
	      <td></td>
	    </tr>
	  </tbody>
  </form>
</table>
</div>
</body>
</html>