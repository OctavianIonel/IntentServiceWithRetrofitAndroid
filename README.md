# IntentServiceWithRetrofitAndroid
This Android application shows an example of a fragment which is lunching an IntentService which will later download data from an API. Afterwards, the calling fragment is informed to update the UI using a ResultReceiver.
There is also a branch "Skeletron_Fragment_EventBus" which make use of EventBus, but in case we need to save the data to a SQLite it is better to do this work from the IntentService.

![alternate text](https://github.com/OctavianIonel/IntentServiceWithRetrofitAndroid/blob/master/intent_service_retrofit.gif)

In order to test this project, all you have to do is to clone it.

Enjoy!

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
