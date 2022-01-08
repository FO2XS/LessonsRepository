using Apiv2.Models;
using Apiv2.Providers;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;

namespace Apiv2.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class StocksController : ControllerBase
    {
        DapperProvider _provider;
        UserProvider _userProvider;

        public StocksController()
        {
            _provider = DapperProvider.GetInstance();
            _userProvider = UserProvider.GetInstance();
        }

        [HttpGet]
        public ActionResult<IEnumerable<Stock>> Get([FromHeader] string token)
        {
            if (!_userProvider.CheckToken(token))
            {
                return Unauthorized();
            }
            var test = new ObjectResult(_provider.GetStocks());
            return test;
        }

        [HttpGet("{figi}")]
        public ActionResult<Stock> Get(string figi, [FromHeader] string token)
        {
            if (!_userProvider.CheckToken(token))
            {
                return Unauthorized();
            }
            try
            {
                return new ObjectResult(_provider.GetStock(figi));
            }
            catch
            {
                return NotFound();
            }
            
        }

        [HttpPost]
        public ActionResult Post(Stock stock, [FromHeader] string token)
        {
            if (!_userProvider.CheckToken(token))
            {
                return Unauthorized();
            }
            if (stock == null)
            {
                return BadRequest();
            }

            if (_provider.AddStock(stock))
            {
                return Ok();
            }
            else
            {
                return NotFound();
            }
            
        }

        [HttpPut]
        public ActionResult Put(Stock user, [FromHeader] string token)
        {
            if (!_userProvider.CheckToken(token))
            {
                return Unauthorized();
            }
            if (user == null)
            {
                return BadRequest();
            }

            if (!_provider.UpdateStock(user))
            {
                return NotFound();
            }

            return Ok();
        }

        [HttpDelete("{figi}")]
        public ActionResult Delete(string figi, [FromHeader] string token)
        {
            if (!_userProvider.CheckToken(token))
            {
                return Unauthorized();
            }
            if (string.IsNullOrEmpty(figi))
            {
                return BadRequest();
            }

            if (!_provider.DeleteStock(figi))
            {
                return NotFound();
            }

            return Ok();
        }
    }
}
