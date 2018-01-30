var size = "small";
var sizeLight = "small"
var dark = document.querySelector(".themes-features .laptop-dark");
var light = document.querySelector(".themes-features .laptop-light");
var item = document.querySelector(".features");//.style.display = "block";

document.querySelector(".lightWordingDark").addEventListener("click", function(){
	if(size=="small"){
//		document.querySelector(".themes-features .laptop-light").style.width = "20%";
//		document.querySelector(".themes-features .laptop-dark").style.width = "80%";
		
		widthGrow(50,80, dark, light,size);
		size = "large";
		sizeLight="small";
	}
	else{
		widthGrow(80, 50, dark, light, size);
		size = "small";
		sizeLight="small";
	}
});

document.querySelector(".lightWordingLight").addEventListener("click", function(){
	if(sizeLight=="small"){
//		document.querySelector(".themes-features .laptop-light").style.width = "20%";
//		document.querySelector(".themes-features .laptop-dark").style.width = "80%";
		
		widthGrow(50,80, light, dark,sizeLight);
		sizeLight = "large";
		size="small";
	}
	else{
		widthGrow(80, 50, light, dark, sizeLight);
		sizeLight = "small";
		size="small";
	}
});

document.querySelector(".navFeature").addEventListener("mouseenter", function(){
	//var item1 = document.querySelector(".features");//.style.display = "block";
	var size = item.clientHeight;
	item.style.display="block";
	featureGrowShrink(size, 60, "grow", item);
});

document.querySelector(".navFeature").addEventListener("mouseleave", function(){
	//var item2 = document.querySelector(".features");
	var size = item.clientHeight;
	
	featureGrowShrink(size, 0, "shrink", item);
});

function featureGrowShrink(size, target, shrinkOrGrow, item){
	
	var id = setInterval(feature, 3);
	
	function feature(){
		if(size==target){
			item.style.height = size + '%';
			clearInterval(id);
		}
		else{
			if(shrinkOrGrow=="shrink"){
				size--;
				if(size==0) {
					item.style.display="none";
				}
			}
			else{
				size++;
			}
			
			console.log(size);
			item.style.height = size + '%';
		}
	}
}

function widthGrow(min, max, element1, element2, size1){
	 var id = setInterval(frame, 10);

	  function frame() {
	    if (min == max) {
	      clearInterval(id);
	    } else {
	    	if(size1=="small"){
	    		min++; 
	    	}
	    		
	    	else {
	    		min--;
	    	}
	    	
	      element1.style.width = min + '%'; 
	      element2.style.width = (100-min) + '%';
	    }
	  }
}