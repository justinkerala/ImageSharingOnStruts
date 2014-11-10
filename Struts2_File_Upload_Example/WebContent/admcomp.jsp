<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="adminhead.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">

		<div id="examples_outer">
			<h2></h2>

			<div id="slider_container_2">

				<div id="SliderName_2" class="SliderName_2">
					<img src="img/1.jpg" width="700" height="450" alt="Demo2 first" title="Demo2 first" usemap="#img1map" />
					<map name="img1map">
						<area href="#img1map-area1" shape="rect" coords="100,100,200,200" />
						<area href="#img1map-area2" shape="rect" coords="300,100,400,200" />
					</map>
					<s:iterator value="Allimages">
					<div class="SliderName_2Description">Featured model: <strong>Charlize Theron</strong></div>
					<img src="<s:property/>" width="700" height="450" alt="Demo2 second" title="Demo2 second" />
				</s:iterator>
				</div>
				<div class="c"></div>
				<div id="SliderNameNavigation_2"></div>
				<div class="c"></div>

				<script type="text/javascript">
					effectsDemo2 = 'rain,stairs,fade';
					var demoSlider_2 = Sliderman.slider({container: 'SliderName_2', width: 700, height: 450, effects: effectsDemo2,
						display: {
							//autoplay: 3000,
							loading: {background: '#000000', opacity: 0.5, image: 'img/loading.gif'},
							buttons: {hide: true, opacity: 1, prev: {className: 'SliderNamePrev_2', label: ''}, next: {className: 'SliderNameNext_2', label: ''}},
							description: {hide: true, background: '#000000', opacity: 0.4, height: 50, position: 'bottom'},
							navigation: {container: 'SliderNameNavigation_2', label: '<img src="img/clear.gif" />'}
						}
					});
				</script>
				<div class="c"></div>
			</div>
			<div class="c"></div>
		</div>

		<div class="c"></div>
	</div>
</body>
</html>