# Desk Java API Client

The Desk API Client is a lightweight static library written in Java that wraps the [Desk.com API V2][1].

## Download
[![Download](https://api.bintray.com/packages/desk/public/api-client/images/download.svg)](https://bintray.com/desk/public/api-client/_latestVersion)

### Gradle integration

Place code in your `build.gradle`

```gradle
repositories {
  jcenter()
}

dependencies {
  compile 'com.desk:api-client:1.4.2-SNAPSHOT'
}
```

## Usage

Create an API Token client as follows:

```
DeskClientBuilder builder = new DeskClientBuilder("mysite.desk.com", "apiToken");
DeskClient client = DeskClient.create(builder);
```

Create an OAuth client as follows:

```
DeskClientBuilder builder = new DeskClientBuilder("mysite.desk.com", "consumerKey", "consumerSecret", "accessToken", "accessTokenSecret");
DeskClient client = DeskClient.create(builder);
```

## License

Copyright (c) 2015, Salesforce.com, Inc.
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.

* Neither the name of Salesforce.com nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

[1]: http://dev.desk.com
[2]: https://github.com/forcedotcom/DeskApiClient-Java/releases/latest
