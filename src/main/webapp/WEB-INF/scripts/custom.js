$(document).ready(function(){
	$("#btnGetNames").click(function(){
		var startYear = $("#startYear").val();
		var endYear = $("#endYear").val();
		if(!$.isNumeric(startYear) || !$.isNumeric(endYear)){
			alert("Enter only numbers in start year");
			return false;
		}
		
		if(!$.isNumeric(endYear)){
			alert("Enter only numbers in end year");
			return false;
		}
		
		if(startYear < 1880 || endYear < 1880){
			alert("Year should be greater than 1880");
			return false;
		}
		
		if(startYear > 2010 || endYear > 2010){
			alert("Year should be greater than 2010");
			return false;
		}
		
		if(startYear > endYear){
			alert("Start year cannot be greater than end year");
			return false;
		}
		
		if(endYear )
		return true;
	});
});