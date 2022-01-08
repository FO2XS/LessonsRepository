using Apiv2.Models;
using Apiv2.Providers;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;

namespace Apiv2.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UserAuthController : ControllerBase
    {
        UserProvider _userProvider;

        public UserAuthController()
        {
            _userProvider = UserProvider.GetInstance();
        }

        [HttpPost]
        public ActionResult<string> Post([FromBody] User user1)
        {

            var cleanLogin = Crypter.GetDecryptString(user1.Login);
            var cleanPassword = Crypter.GetDecryptString(user1.Password);

            try
            {
                User user = _userProvider.Authorization(
                    Crypter.GetHashString(cleanLogin),
                    Crypter.GetHashString(cleanPassword));

                var token = Crypter.GenerateKey();
               _userProvider.AuthTokens.Add(token);

                return new ObjectResult(token);
            }
            catch
            {
                return NotFound();
            }
        }
    }
}
