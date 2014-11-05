<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
<div id='stars'></div>
<style type='text/css'>
<!-- class with full star -->
.staron
{
    float: left;
    height: 16px;
    width: 16px;
    background-image: url(./images/stars.png);
    background-position: 0px 16px;
}
<!-- class with empty star -->
.staroff
{
    float: left;
    height: 16px;
    width: 16px;
    background-image: url(./images/stars.png);
    background-position: 0px 0px;
}
</style>

<div id="wrapper">

		<div id="examples_outer">
			<h2></h2>

			<div id="slider_container_2">

				<div id="SliderName_2" class="SliderName_2">
					
					<map name="img1map">
						<area href="#img1map-area1" shape="rect" coords="100,100,200,200" />
						<area href="#img1map-area2" shape="rect" coords="300,100,400,200" />
					</map>
					 
					<s:iterator value="userPics" status="upics" id="up">
					<s:iterator value="picLikes" status="ulikes" id="hh"> 
					 <s:if test="#upics.count == #ulikes.count">	
					<s:url id="url" action="rateP">
                    <s:param name="picture"><s:property value="up"/></s:param>
                    </s:url>
					<div class="SliderName_2Description"><s:a href="%{url}" >LIKE</s:a>Featured model: <strong>Charlize Theron<s:property value="hh"/></strong></div>
					<img src="<s:property value="up" />" width="700" height="450" alt="Demo2 second" title="Demo2 second" />
					</s:if>
					</s:iterator>
				
       
  
				
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