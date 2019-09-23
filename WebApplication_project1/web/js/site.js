               
                
                function isEmpty ()
                {
                var bookNumber = document.getElementById("bn");
                var bookTitle = document.getElementById("bt");
                var bookVersion = document.getElementById("bv");
                var bookYear = document.getElementById("by");
                var bookAuthor = document.getElementById("ba");
                    if(bookNumber.value.length==0||bookTitle.value.length==0||bookVersion.value.length==0||bookYear.value.length==0||bookAuthor.value.length==0)
                    {
                        window.alert("All fields must be filled");
                        return false;
                    }
                    else 
                    {
                        return true;
                    }
                 
                    
                }
                
                function isEmpty2 ()
                {
                var id = document.getElementById("id");
                var name = document.getElementById("name");
                var email = document.getElementById("email");
                var subject = document.getElementById("sub");
                var msg = document.getElementById("message_area");
                    if(id.value.length==0||name.value.length==0||email.value.length==0||subject.value.length==0||msg.value.length==0)
                    {
                        window.alert("All fields with star must be filled");
                        return false;
                    }
                    else 
                    {
                        return true;
                    }
                }
                    
                    function isEmpty3 ()
                {
                var full_name = document.getElementById("fn");
                var pass = document.getElementById("password");
                var repass = document.getElementById("rpassword");
                var email = document.getElementById("email");
                    if(full_name.value.length==0||pass.value.length==0||repass.value.length==0||email.value.length==0)
                    {
                        window.alert("All fields must be filled");
                        return false;
                        
                       
                    }
                      if(pass.value != repass.value)
                        {
                            window.alert("password and repeat password dont match")
                        return false;
                    }
                  
                    else 
                    {
                        return true;
                    }
                 
                    
                }
                
                function passMatch ()
                {
                   
                var pass = document.getElementById("password");
                var repass = document.getElementById("rpassword");
       
                    
                      
                }

function dummy()
{
    var session =session.getAttribute("user");
    window.alert(session);
}