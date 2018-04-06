(function(namespace, $) {
    "use strict";

    var DemoFormWizard = function() {
        // Create reference to this instance
        var o = this;
        // Initialize app when document is ready
        $(document).ready(function() {
            o.initialize();
        });

    };
    var p = DemoFormWizard.prototype;

    // =========================================================================
    // INIT
    // =========================================================================

    p.initialize = function() {
        this._initWizard1();
        this._initWizard3();
        this._initWizard4();
    };

    // =========================================================================
    // WIZARD 1
    // =========================================================================

    p._initWizard1 = function() {
        var o = this;
        $('#rootwizard1').bootstrapWizard({
            onTabShow: function(tab, navigation, index) {
                o._handleTabShow(tab, navigation, index, $('#rootwizard1'));
            },
             onNext: function(tab, navigation, index) {
                 if (index==1) {
                      
                      var valid = 0;
                     
                     var val = $('#SubCentre').val();
                     var isDisabled = $('#SubCentre').prop('disabled');
                         if ((val == "") && (!isDisabled)) {
                             $('#errMessage1').show();
                         /*    valid = 1;*/
                     }            
                     var val = $('#mode_of_detection').val();
                         if (val == "") {
                             $('#errMessageMode').show();
                             valid = 1;
                         }            
                     var val = $('#anyLep').val();
                     if (val == "") {
                         $('#errMessageAnyLep').show();
                         valid = 1;
                     } else if (val == "Y") {
                         var reqlength = $('.isempty').length;
                         var value = $('.isempty').filter(function () {
                            return this.value != '';
                        });

                         if (value.length>=0 && (value.length !== reqlength)) {
                            $('#errMessagePatientName').html("Please enter values of Known Patients").show();
                              valid=1;
                          }
                     }
                     if(valid==1) {
                         return false;
                     }
                  }
                  
                  if(index==2) {
                      
                     var val = $('#firstName').val();
                         if (val == "") {
                             $('#errMessage2').show();
                             valid = 1;
                     }
                         
                        /* var val = $('#lastName').val();
                         if (val == "") {
                             $('#errMessage3').show();
                             valid = 1;
                     }*/
                     
                         var val = $('#gender').val();
                         if (val == "") {
                             $('#errMessageGender').show();
                             valid = 1;
                     }
                     var val = $('#mobileNumber').val();
                     var filter = /^[7-9][0-9]{9}$/;
                     if (!filter.test(val))     {
                      /*   $('#errMessage5').html("Invalid Mobile Number").show();
                             valid = 1;*/
                     }
                     
                     var val = $('#ageYear').val();
                    var val1 = $('#ageMonth').val();
                    if (val == "0" && val1 == "0") {
                         $('#errMessageAge').html("Age cannot be 0").show();
                         valid = 1;
                     } else if (val == "" && val1 == "") {
                         $('#errMessageAge').html("Please specify the age of the suspect").show();
                         valid = 1;
                     }
                     
                     if(valid==1) {
                         return false;
                     }
                     
                 }
                  
                  if(index==3) {
                      var val = $('#govtIdCard').val();
                     if(val != ""){
                         var val2 = $('#idCardNumber').val();
                         if(val2 == ""){
                             $('#errMessageidCard').show();
                             valid = 1;
                         }
                     }
                      var val = $('#AddState').val();
                     if (val == "") {
                         $('#errMessageAddressState').show();
                         valid = 1;
                     }
                     var val = $('#AddDistrict').val();
                     if (val == "") {
                         $('#errMessageAddressDistrict').show();
                         valid = 1;
                     }
                     var val = $('#VillageCity').val();
                     if (val == "") {
                         $('#errMessageAddressVillage').show();
                         valid = 1;
                     }
                     var val = $('#AddressLine1').val();
                     if (val == "") {
                         $('#errMessageAddressLine1').show();
                         valid = 1;
                     }
                     var pin = $('#PinCode').val();
                     if (pin == "") {
                         $('#errMessagePinCode').show();
                         valid = 1;
                     } else if (pin.length < 6) {
                         $('#errMessagePinCode').html("Invalid pincode, it must contains 6 digits").show();
                         valid = 1;
                     }  
                     
                     if(valid==1) {
                         return false;
                     }
                  }
             }
        });
    };

    p._handleTabShow = function(tab, navigation, index, wizard){
        var total = navigation.find('li').length;
        var current = index + 0;
        var percent = (current / (total - 1)) * 100;
        var percentWidth = 100 - (100 / total) + '%';
        
        navigation.find('li').removeClass('done');
        navigation.find('li.active').prevAll().addClass('done');
        wizard.find('.progress-bar').css({width: percent + '%'});
        $('.form-wizard-horizontal').find('.progress').css({'width': percentWidth});
        debugger;
        if(current+1 >= total) {
            $('#rootwizard1').find('.pager .next').hide();
            $('#rootwizard1').find('.pager .finish').show();
            $('#rootwizard1').find('.pager .finish').removeClass('disabled');
        } else {
            $('#rootwizard1').find('.pager .next').show();
            $('#rootwizard1').find('.pager .finish').hide();
        }
        
    };
    

    
    // =========================================================================
    // WIZARD 1
    // =========================================================================

    p._initWizard3 = function() {
        var o = this;
        $('#rootwizard3').bootstrapWizard({
            onTabShow: function(tab, navigation, index) {
                o._handleTabShow2(tab, navigation, index, $('#rootwizard3'));
            },
             onNext: function(tab, navigation, index) {
                 if (index==1) {
                      
                      var valid = 0;
                     
                     var val = $('#SubCentre').val();
                     var isDisabled = $('#SubCentre').prop('disabled');
                         if ((val == "") && (!isDisabled)) {
                             $('#errMessage1').show();
                           /*  valid = 1;*/
                     }            
                     var val = $('#mode_of_detection').val();
                         if (val == "") {
                             $('#errMessageMode').show();
                             valid = 1;
                         }            
                     
                     if(valid==1) {
                         return false;
                     }
                  }
                  
                  if(index==2) {
                      
                     var val = $('#firstName').val();
                         if (val == "") {
                             $('#errMessage2').show();
                             valid = 1;
                     }
                         
                        /* var val = $('#lastName').val();
                         if (val == "") {
                             $('#errMessage3').show();
                             valid = 1;
                     }*/
                     
                         var val = $('#gender').val();
                         if (val == ' ' || val == "") {
                             $('#errMessageGender').show();
                             valid = 1;
                     }
                     var val = $('#mobileNumber').val();
                     var filter = /^[7-9][0-9]{9}$/;
                     if (!filter.test(val))     {
                       /*  $('#errMessage5').html("Invalid Mobile Number").show();
                             valid = 1;*/
                     }
                     
                     var val = $('#ageYear').val();
                    var val1 = $('#ageMonth').val();
                    if (val == "0" && val1 == "0") {
                         $('#errMessageAge').html("Age cannot be 0").show();
                         valid = 1;
                     } else if (val == "" && val1 == "") {
                         $('#errMessageAge').html("Please specify the age of the suspect").show();
                         valid = 1;
                     }
                     
                     if(valid==1) {
                         return false;
                     }
                     
                 }
                  
                  if(index==3) {
                      var val = $('#govtIdCard').val();
                     if(val != ""){
                         var val2 = $('#idCardNumber').val();
                         if(val2 == ""){
                             $('#errMessageidCard').show();
                             valid = 1;
                         }
                     }
                      var val = $('#AddState').val();
                     if (val == "") {
                         $('#errMessageAddressState').show();
                         valid = 1;
                     }
                     var val = $('#AddDistrict').val();
                     if (val == "") {
                         $('#errMessageAddressDistrict').show();
                         valid = 1;
                     }
                     var val = $('#VillageCity').val();
                     if (val == "") {
                         $('#errMessageAddressVillage').show();
                         valid = 1;
                     }
                     var val = $('#AddressLine1').val();
                     if (val == "") {
                         $('#errMessageAddressLine1').show();
                         valid = 1;
                     }
                     var pin = $('#PinCode').val();
                     if (pin == "") {
                         $('#errMessagePinCode').show();
                         valid = 1;
                     } else if (pin.length < 6) {
                         $('#errMessagePinCode').html("Invalid pincode, it must contains 6 digits").show();
                         valid = 1;
                     }  
                     
                     if(valid==1) {
                         return false;
                     }
                  }
                  
              if(index==4) {
                   var val = $('#caseCategory').val();
                  if (val == "") {
                      $('#errMessageCaseCategory').show();
                      valid = 1;
                  }
                  var val = $('#caseClassification').val();
                  if (val == "") {
                      $('#errMessageCaseClassification').show();
                      valid = 1;
                  }
                  
                  if(valid==1) {
                      return false;
                  }
               }
             }
        });
    };

    p._handleTabShow2 = function(tab, navigation, index, wizard){
        var total = navigation.find('li').length;
        var current = index + 0;
        var percent = (current / (total - 1)) * 100;
        var percentWidth = 100 - (100 / total) + '%';
        
        navigation.find('li').removeClass('done');
        navigation.find('li.active').prevAll().addClass('done');
        wizard.find('.progress-bar').css({width: percent + '%'});
        $('.form-wizard-horizontal').find('.progress').css({'width': percentWidth});
        debugger;
        if(current+1 >= total) {
            $('#rootwizard3').find('.pager .next').hide();
            $('#rootwizard3').find('.pager .finish').show();
            $('#rootwizard3').find('.pager .finish').removeClass('disabled');
        } else {
            $('#rootwizard3').find('.pager .next').show();
            $('#rootwizard3').find('.pager .finish').hide();
        }
        
    };
    
 // =========================================================================
    // WIZARD 4
    // =========================================================================

    p._initWizard4 = function() {
        var o = this;
        $('#rootwizard1').bootstrapWizard({
            onTabShow: function(tab, navigation, index) {
                o._handleTabShow4(tab, navigation, index, $('#rootwizard1'));
            },
             onNext: function(tab, navigation, index) {
                 
             }
        });
    };

    p._handleTabShow4 = function(tab, navigation, index, wizard){
        var total = navigation.find('li').length;
        var current = index + 0;
        var percent = (current / (total - 1)) * 100;
        var percentWidth = 100 - (100 / total) + '%';
        
        navigation.find('li').removeClass('done');
        navigation.find('li.active').prevAll().addClass('done');
        wizard.find('.progress-bar').css({width: percent + '%'});
        $('.form-wizard-horizontal').find('.progress').css({'width': percentWidth});
        debugger;
        if(current+1 >= total) {
            $('#rootwizard1').find('.pager .next').hide();
            $('#rootwizard1').find('.pager .finish').show();
            $('#rootwizard1').find('.pager .finish').removeClass('disabled');
        } else {
            $('#rootwizard1').find('.pager .next').show();
            $('#rootwizard1').find('.pager .finish').hide();
        }
        
    };
    
    
    
    
    // =========================================================================
    namespace.DemoFormWizard = new DemoFormWizard;
}(this.materialadmin, jQuery)); // pass in (namespace, jQuery):

/*(function(namespace, $) {
	"use strict";

	var DemoFormWizard = function() {
		// Create reference to this instance
		var o = this;
		// Initialize app when document is ready
		$(document).ready(function() {
			o.initialize();
		});

	};
	var p = DemoFormWizard.prototype;

	// =========================================================================
	// INIT
	// =========================================================================

	p.initialize = function() {
		this._initWizard1();
		this._initWizard3();
	};

	// =========================================================================
	// WIZARD 1
	// =========================================================================

	p._initWizard1 = function() {
		var o = this;
		$('#rootwizard1').bootstrapWizard({
			onTabShow: function(tab, navigation, index) {
				o._handleTabShow(tab, navigation, index, $('#rootwizard1'));
			},
	  		onNext: function(tab, navigation, index) {
	  			if (index==1) {
	  	  			
	  	  			var valid = 0;
	  		 	 	
	  		 	 	var val = $('#SubCentre').val();
	  				var isDisabled = $('#SubCentre').prop('disabled');
	  	 				if ((val == "") && (!isDisabled)) {
	  	 					$('#errMessage1').show();
	  	 					valid = 1;
	  	 			}			
	  	 			var val = $('#mode_of_detection').val();
	  					if (val == "") {
	  						$('#errMessageMode').show();
	  						valid = 1;
	  					}			
	  				var val = $('#anyLep').val();
	  				if (val == "") {
	  					$('#errMessageAnyLep').show();
	  					valid = 1;
	  				} else if (val == "Y") {
	  					var reqlength = $('.isempty').length;
	  					var value = $('.isempty').filter(function () {
	  				        return this.value != '';
	  				    });

	  					if (value.length>=0 && (value.length !== reqlength)) {
                            $('#errMessagePatientName').html("Please enter values of Known Patients").show();
                              valid=1;
                          }
	  				}
	  				if(valid==1) {
	  					return false;
	  				}
	  	  		}
	  	  		
	  	  		if(index==2) {
	  	  			
	  				var val = $('#firstName').val();
	  	 				if (val == "") {
	  	 					$('#errMessage2').show();
	  	 					valid = 1;
	  	 			}
	  	 				
	  					var val = $('#lastName').val();
	  					if (val == "") {
	  						$('#errMessage3').show();
	  						valid = 1;
	  	 			}
	  				
	  					var val = $('#gender').val();
	  	 				if (val == "") {
	  	 					$('#errMessageGender').show();
	  	 					valid = 1;
	  	 			}
	  	 			var val = $('#mobileNumber').val();
	  	 			var filter = /^[7-9][0-9]{9}$/;
	  	 			if (!filter.test(val)) 	{
	  	 				$('#errMessage5').html("Invalid Mobile Number").show();
	  						valid = 1;
	  				}
	  	 			
	  				var val = $('#ageYear').val();
	 				var val1 = $('#ageMonth').val();
	 				if (val == "0" && val1 == "0") {
	  					$('#errMessageAge').html("Age cannot be 0").show();
	  					valid = 1;
	  				} else if (val == "" && val1 == "") {
	  					$('#errMessageAge').html("Please specify the age of the suspect").show();
	  					valid = 1;
	  				}
	  				
	  				if(valid==1) {
	  					return false;
	  				}
	  				
	  			}
	  	  		
	  	  		if(index==3) {
	  	  			var val = $('#AddState').val();
	  				if (val == "") {
	  					$('#errMessageAddressState').show();
	  					valid = 1;
	  				}
	  				var val = $('#AddDistrict').val();
	  				if (val == "") {
	  					$('#errMessageAddressDistrict').show();
	  					valid = 1;
	  				}
	  				var val = $('#VillageCity').val();
	  				if (val == "") {
	  					$('#errMessageAddressVillage').show();
	  					valid = 1;
	  				}
	  				var val = $('#AddressLine1').val();
	  				if (val == "") {
	  					$('#errMessageAddressLine1').show();
	  					valid = 1;
	  				}
	  				var pin = $('#PinCode').val();
	  				if (pin == "") {
	  					$('#errMessagePinCode').show();
	  					valid = 1;
	  				} else if (pin.length < 6) {
	  					$('#errMessagePinCode').html("Invalid pincode, it must contains 6 digits").show();
	  					valid = 1;
	  				}  
	  				
	  				if(valid==1) {
	  					return false;
	  				}
	  	  		}
	  		}
		});
	};

	p._handleTabShow = function(tab, navigation, index, wizard){
		var total = navigation.find('li').length;
		var current = index + 0;
		var percent = (current / (total - 1)) * 100;
		var percentWidth = 100 - (100 / total) + '%';
		
		navigation.find('li').removeClass('done');
		navigation.find('li.active').prevAll().addClass('done');
		wizard.find('.progress-bar').css({width: percent + '%'});
		$('.form-wizard-horizontal').find('.progress').css({'width': percentWidth});
		debugger;
		if(current+1 >= total) {
			$('#rootwizard1').find('.pager .next').hide();
			$('#rootwizard1').find('.pager .finish').show();
			$('#rootwizard1').find('.pager .finish').removeClass('disabled');
		} else {
			$('#rootwizard1').find('.pager .next').show();
			$('#rootwizard1').find('.pager .finish').hide();
		}
		
	};
	

	
	// =========================================================================
	// WIZARD 1
	// =========================================================================

	p._initWizard3 = function() {
		var o = this;
		$('#rootwizard3').bootstrapWizard({
			onTabShow: function(tab, navigation, index) {
				o._handleTabShow2(tab, navigation, index, $('#rootwizard3'));
			},
	  		onNext: function(tab, navigation, index) {
	  			if (index==1) {
	  	  			
	  	  			var valid = 0;
	  		 	 	
	  		 	 	var val = $('#SubCentre').val();
	  				var isDisabled = $('#SubCentre').prop('disabled');
	  	 				if ((val == "") && (!isDisabled)) {
	  	 					$('#errMessage1').show();
	  	 					valid = 1;
	  	 			}			
	  	 			var val = $('#mode_of_detection').val();
	  					if (val == "") {
	  						$('#errMessageMode').show();
	  						valid = 1;
	  					}			
	  				
	  				if(valid==1) {
	  					return false;
	  				}
	  	  		}
	  	  		
	  	  		if(index==2) {
	  	  			
	  				var val = $('#firstName').val();
	  	 				if (val == "") {
	  	 					$('#errMessage2').show();
	  	 					valid = 1;
	  	 			}
	  	 				
	  					var val = $('#lastName').val();
	  					if (val == "") {
	  						$('#errMessage3').show();
	  						valid = 1;
	  	 			}
	  				
	  					var val = $('#gender').val();
	  	 				if (val == ' ' || val == "") {
	  	 					$('#errMessageGender').show();
	  	 					valid = 1;
	  	 			}
	  	 			var val = $('#mobileNumber').val();
	  	 			var filter = /^[7-9][0-9]{9}$/;
	  	 			if (!filter.test(val)) 	{
	  	 				$('#errMessage5').html("Invalid Mobile Number").show();
	  						valid = 1;
	  				}
	  	 			
	  				var val = $('#ageYear').val();
	 				var val1 = $('#ageMonth').val();
	 				if (val == "0" && val1 == "0") {
	  					$('#errMessageAge').html("Age cannot be 0").show();
	  					valid = 1;
	  				} else if (val == "" && val1 == "") {
	  					$('#errMessageAge').html("Please specify the age of the suspect").show();
	  					valid = 1;
	  				}
	  				
	  				if(valid==1) {
	  					return false;
	  				}
	  				
	  			}
	  	  		
	  	  		if(index==3) {
	  	  			var val = $('#AddState').val();
	  				if (val == "") {
	  					$('#errMessageAddressState').show();
	  					valid = 1;
	  				}
	  				var val = $('#AddDistrict').val();
	  				if (val == "") {
	  					$('#errMessageAddressDistrict').show();
	  					valid = 1;
	  				}
	  				var val = $('#VillageCity').val();
	  				if (val == "") {
	  					$('#errMessageAddressVillage').show();
	  					valid = 1;
	  				}
	  				var val = $('#AddressLine1').val();
	  				if (val == "") {
	  					$('#errMessageAddressLine1').show();
	  					valid = 1;
	  				}
	  				var pin = $('#PinCode').val();
	  				if (pin == "") {
	  					$('#errMessagePinCode').show();
	  					valid = 1;
	  				} else if (pin.length < 6) {
	  					$('#errMessagePinCode').html("Invalid pincode, it must contains 6 digits").show();
	  					valid = 1;
	  				}  
	  				
	  				if(valid==1) {
	  					return false;
	  				}
	  	  		}
	  	  		
	  	  	if(index==4) {
  	  			var val = $('#caseCategory').val();
  				if (val == "") {
  					$('#errMessageCaseCategory').show();
  					valid = 1;
  				}
  				var val = $('#caseClassification').val();
  				if (val == "") {
  					$('#errMessageCaseClassification').show();
  					valid = 1;
  				}
  				
  				if(valid==1) {
  					return false;
  				}
  	  		}
	  		}
		});
	};

	p._handleTabShow2 = function(tab, navigation, index, wizard){
		var total = navigation.find('li').length;
		var current = index + 0;
		var percent = (current / (total - 1)) * 100;
		var percentWidth = 100 - (100 / total) + '%';
		
		navigation.find('li').removeClass('done');
		navigation.find('li.active').prevAll().addClass('done');
		wizard.find('.progress-bar').css({width: percent + '%'});
		$('.form-wizard-horizontal').find('.progress').css({'width': percentWidth});
		debugger;
		if(current+1 >= total) {
			$('#rootwizard3').find('.pager .next').hide();
			$('#rootwizard3').find('.pager .finish').show();
			$('#rootwizard3').find('.pager .finish').removeClass('disabled');
		} else {
			$('#rootwizard3').find('.pager .next').show();
			$('#rootwizard3').find('.pager .finish').hide();
		}
		
	};
	
	
	
	
	// =========================================================================
	namespace.DemoFormWizard = new DemoFormWizard;
}(this.materialadmin, jQuery)); // pass in (namespace, jQuery):
*/